package ecommerce.com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.com.daos.UserDao;
import ecommerce.com.daos.UserRoleDao;
import ecommerce.com.models.User;
import ecommerce.com.models.UserRole;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");

		User user = new User(0, username, password, fullName, email, phoneNumber);

		try {
			UserDao.addUser(user);
			int userId = UserDao.getLastUserId();
			UserRole userRole = new UserRole();
			userRole.setUser_id(userId);
			userRole.setRole_id(0);
			UserRoleDao.addUserRole(userRole);
			response.sendRedirect(request.getContextPath() + "/login");
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Unable to register user. Please try again later.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}
}
