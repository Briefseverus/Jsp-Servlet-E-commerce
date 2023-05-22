package ecommerce.com.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import ecommerce.com.mapper.CartToOrderDetailMapper;
import ecommerce.com.models.Cart;
import ecommerce.com.models.CartItem;
import ecommerce.com.models.Order;
import ecommerce.com.models.OrderDetail;
import ecommerce.com.models.Product;
import ecommerce.com.models.User;

@WebServlet("/Cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("view")) {
			// Hiển thị trang giỏ hàng
			HttpSession session = request.getSession(false);
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart != null) {
				request.setAttribute("cartItems", cart.getItems());
				request.setAttribute("cart", cart);
			}
			request.getRequestDispatcher("/views/user/Cart.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");

		String action = request.getParameter("action");
		if (action != null && action.equals("add")) {
			int productId = Integer.parseInt(request.getParameter("product_id"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			addToCart(productId, quantity, cart, session);
			response.sendRedirect(request.getContextPath());
		} else if (action != null && action.equals("checkout")) {

			if (cart != null && !cart.isEmpty()) {
				Order order = new Order();
				order.setUser_id(user.getUser_id());
				OrderDao orderDao = new OrderDao();
				try {
					orderDao.addOrder(order);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CartToOrderDetailMapper mapper = new CartToOrderDetailMapper();
				Order tmp = null;
				try {
					tmp = orderDao.getNewestOrderByUserId(user.getUser_id());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				List<OrderDetail> orderDetails = mapper.mapToOrderDetail(cart, tmp.getOrder_id());

				OrderDetailDao orderDetailDao = new OrderDetailDao();
				try {

					for (OrderDetail orderDetail : orderDetails) {
						orderDetailDao.addOrderDetail(orderDetail);
					}

					session.removeAttribute("cart");
					response.sendRedirect(request.getContextPath() + "/OrderDisplay");
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect(request.getContextPath() + "/error.jsp");
				}
			} else {
				response.sendRedirect(request.getContextPath() + "/Cart");
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/Cart");
		}
	}

	void addToCart(int productId, int quantity, Cart cart, HttpSession session) {
		CartItem cartItem = new CartItem(productId, quantity);
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		cart.addItem(cartItem);
	}

	// Additional method for HomeController to call addToCart
	public void addToCartFromHomeController(int productId, int quantity, HttpSession session) {
		Cart cart = (Cart) session.getAttribute("cart");
		addToCart(productId, quantity, cart, session);
	}

	public int getCartItemCount(Cart cart) {
		if (cart == null) {
			return 0;
		}
		return cart.getItems().size();
	}

}
