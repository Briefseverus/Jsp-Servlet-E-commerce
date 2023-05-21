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
import ecommerce.com.models.Product;
import ecommerce.com.models.User;

@WebServlet("/UserManage")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserDao proDao = new UserDao();
			List<User> pros = proDao.getAllUser();
			request.setAttribute("pros", pros);
			String action = request.getParameter("action");
			if (action != null && "load".equals(action)) {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				User user = proDao.getuserById(user_id);
				request.setAttribute("the_user", user);
				request.getRequestDispatcher("/views/admin/user/UserEditManage.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("views/admin/user/UserManage.jsp").forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String full_name = request.getParameter("full_name");
			String email = request.getParameter("email");
			String phone_number = request.getParameter("phone_number");

			User pro = new User(0, username, password, full_name, email, phone_number);

			try {
				UserDao.addUser(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserManage");
		} else if ("deactivate".equals(action)) {
			int UserId = Integer.parseInt(request.getParameter("user_id"));
			boolean activated = Boolean.parseBoolean(request.getParameter("activated"));

			try {
				UserDao.deactivateUserById(UserId, activated);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserManage");
		} else if ("edit".equals(action)) {
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String full_name = (request.getParameter("full_name"));
			String email = request.getParameter("email");
			String phone_number = (request.getParameter("phone_number"));

			User pro = new User(user_id, username, password, full_name, email, phone_number);

			try {
				UserDao.updateUser(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserManage");
		}
	}
}
