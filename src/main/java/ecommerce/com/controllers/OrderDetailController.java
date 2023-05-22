package ecommerce.com.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.com.daos.OrderDetailDao;
import ecommerce.com.models.OrderDetail;

@WebServlet("/OrderDetailManage")
public class OrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			OrderDetailDao proDao = new OrderDetailDao();
			List<OrderDetail> pros = proDao.getAllOrderDetail();
			request.setAttribute("pros", pros);
			request.getRequestDispatcher("/views/admin/order/OrderDetailManage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {

			int order_id = Integer.parseInt(request.getParameter("order_id"));
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			OrderDetail pro = new OrderDetail(0, order_id, product_id, quantity);

			try {
				OrderDetailDao.addOrderDetail(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/OrderDetailManage");
		} else if ("delete".equals(action)) {
			int OrderDetailId = Integer.parseInt(request.getParameter("order_detail_id"));

			try {
				OrderDetailDao.deleteOrderDetailById(OrderDetailId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/OrderDetailManage");
		} else if ("edit".equals(action)) {
			int order_detail_id = Integer.parseInt(request.getParameter("order_detail_id"));
			int order_id = Integer.parseInt(request.getParameter("order_id"));
			int product_id = Integer.parseInt(request.getParameter("product_id"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			OrderDetail pro = new OrderDetail(order_detail_id, order_id, product_id, quantity);
			try {
				OrderDetailDao.updateOrderDetail(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/OrderDetailManage");
		}
	}
}
