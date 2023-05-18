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

import ecommerce.com.daos.OrderDao;
import ecommerce.com.models.Order;

@WebServlet("/OrderManage")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Order> pros = OrderDao.getAllOrder();
			request.setAttribute("pros", pros);
			request.getRequestDispatcher("OrderManage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {

			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String order_status = request.getParameter("order_status");
			Order pro = new Order(0, user_id);

			try {
				OrderDao.addOrder(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/OrderManage");
		} else if ("delete".equals(action)) {
			int OrderId = Integer.parseInt(request.getParameter("order_id"));

			try {
				OrderDao.deleteOrderById(OrderId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/OrderManage");
		} else if ("edit".equals(action)) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			int order_id = Integer.parseInt(request.getParameter("order_id"));
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String order_status = request.getParameter("order_status");

			Order pro = new Order(order_id, user_id, order_status);
			try {
				OrderDao.updateOrder(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/OrderManage");
		}
	}
}
