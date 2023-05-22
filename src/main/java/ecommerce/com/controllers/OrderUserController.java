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

import ecommerce.com.daos.OrderDao;
import ecommerce.com.daos.OrderDetailDao;
import ecommerce.com.daos.ProductDao;
import ecommerce.com.mapper.OrderToCartMapper;
import ecommerce.com.models.Cart;
import ecommerce.com.models.CartItem;
import ecommerce.com.models.Order;
import ecommerce.com.models.OrderDetail;
import ecommerce.com.models.User;

@WebServlet("/OrderDisplay")
public class OrderUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		try {
			List<Order> pros = OrderDao.getAllOrderByUserID(user.getUser_id());
			request.setAttribute("pros", pros);
			request.getRequestDispatcher("/views/user/order/OrderDisplay.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		try {
			int orderid = Integer.parseInt(request.getParameter("orderid"));
			List<OrderDetail> orderDetails = OrderDetailDao.getOrderDetailByOrderId(orderid);

			// Tạo một đối tượng Cart
			Cart cart = new Cart();

			// Lặp qua từng OrderDetail và chuyển đổi thành CartItem
			ProductDao productDao = new ProductDao();
			for (OrderDetail orderDetail : orderDetails) {
				// Chuyển đổi OrderDetail thành CartItem sử dụng phương thức mapToCartItem
				CartItem cartItem = OrderToCartMapper.mapToCartItem(orderDetail, productDao);

				// Nếu cartItem khác null, thêm vào Cart
				if (cartItem != null) {
					cart.addItem(cartItem);
				}
			}
			// Truyền danh sách CartItem qua cho JSP
			request.setAttribute("cartItems", cart.getItems());
			request.setAttribute("cart", cart);
			request.getRequestDispatcher("/views/user/order/OrderDetailDisplay.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
