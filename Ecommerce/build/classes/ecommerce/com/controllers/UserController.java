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

import ecommerce.com.daos.UserDao;
import ecommerce.com.models.user;

@WebServlet("/UserManage")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao proDao = new UserDao();
			List<user> pros = proDao.getAllUser();
			request.setAttribute("pros", pros);
			request.getRequestDispatcher("UserManage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {

			String UserName = request.getParameter("User_name");
			String description = request.getParameter("description");
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			String UserImg = request.getParameter("User_img");
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			User pro = new User(0, quantity, description, UserName, price, UserImg);

			try {
				UserDao.addUser(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserManage");
		} else if ("delete".equals(action)) {
			int UserId = Integer.parseInt(request.getParameter("User_id"));

			try {
				UserDao.deleteUserById(UserId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserManage");
		} else if ("edit".equals(action)) {
			int UserId = Integer.parseInt(request.getParameter("User_id"));
			String UserName = request.getParameter("User_name");
			String description = request.getParameter("description");
			BigDecimal price = new BigDecimal(request.getParameter("price"));
			String UserImg = request.getParameter("User_img");
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			User pro = new User(UserId, quantity, description, UserName, price, UserImg);

			try {
				UserDao.updateUser(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserManage");
		}
	}
}
