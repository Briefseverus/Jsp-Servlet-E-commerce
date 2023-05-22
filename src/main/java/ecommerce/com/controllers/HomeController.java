package ecommerce.com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.com.daos.ProductDao;
import ecommerce.com.daos.UserDao;
import ecommerce.com.models.Cart;
import ecommerce.com.models.Product;

@WebServlet("/Home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ProductDao proDao = new ProductDao();
			List<Product> pros = proDao.getAllproduct();
			request.setAttribute("products", pros);
			String action = request.getParameter("action");
			
			if (action != null && "load".equals(action)) {
				int product_id = Integer.parseInt(request.getParameter("product_id"));
				Product product = proDao.getProductById(product_id);
				request.setAttribute("detailProduct", product);
				request.getRequestDispatcher("views/user/detailProductDisplay.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("views/user/homeDisplay.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        int productId = Integer.parseInt(request.getParameter("product_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        CartController cartController = new CartController();
        cartController.addToCart(productId, quantity, (Cart) session.getAttribute("cart"), session);
        // Cập nhật lại giá trị của biến cartItemCount
        int cartItemCount = cartController.getCartItemCount((Cart) session.getAttribute("cart"));
        session.setAttribute("cartItemCount", cartItemCount);

        // Redirect to the appropriate page
        response.sendRedirect(request.getContextPath() + "/Home");
    }

}
