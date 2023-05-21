package ecommerce.com.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.com.daos.ProductDao;
import ecommerce.com.models.Product;

@WebServlet("/ProductManage")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProductDao proDao = new ProductDao();
			List<Product> pros = proDao.getAllproduct();
			request.setAttribute("pros", pros);
			String action = request.getParameter("action");
			if (action != null && "load".equals(action)) {
				int product_id = Integer.parseInt(request.getParameter("product_id"));
				Product product = proDao.getProductById(product_id);
				request.setAttribute("the_product", product);
				request.getRequestDispatcher("/views/admin/product/productEditManage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/admin/product/ProductManage.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {

			String productName = request.getParameter("product_name");
			String description = request.getParameter("description");
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			String productImg = request.getParameter("product_img");
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			Product pro = new Product(0, quantity, description, productName, price, productImg);

			try {
				ProductDao.addProduct(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/ProductManage");
		} else if ("delete".equals(action)) {
			int productId = Integer.parseInt(request.getParameter("product_id"));

			try {
				ProductDao.deleteProductById(productId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/ProductManage");
		} else if ("edit".equals(action)) {
			int productId = Integer.parseInt(request.getParameter("product_id"));
			String productName = request.getParameter("product_name");
			String description = request.getParameter("description");
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			String productImg = request.getParameter("product_img");
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			Product pro = new Product(productId, quantity, description, productName, price, productImg);

			try {
				ProductDao.updateProduct(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/ProductManage");
		}
	}
}
