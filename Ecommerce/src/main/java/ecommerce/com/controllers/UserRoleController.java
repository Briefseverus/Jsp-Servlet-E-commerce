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

import ecommerce.com.daos.UserRoleDao;
import ecommerce.com.models.UserRole;

@WebServlet("/UserRoleManage")
public class UserRoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UserRoleDao proDao = new UserRoleDao();
			List<UserRole> pros = proDao.getAllUserRole();
			request.setAttribute("pros", pros);
			request.getRequestDispatcher("UserRoleManage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {

			int user_id = Integer.parseInt(request.getParameter("user_id"));
			int role_id = Integer.parseInt(request.getParameter("role_id"));
			UserRole pro = new UserRole(0, user_id, role_id);

			try {
				UserRoleDao.addUserRole(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserRoleManage");
		} else if ("delete".equals(action)) {
			int UserRoleId = Integer.parseInt(request.getParameter("user_role_id"));

			try {
				UserRoleDao.deleteUserRoleById(UserRoleId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserRoleManage");
		} else if ("edit".equals(action)) {
			int user_role_id = Integer.parseInt(request.getParameter("user_role_id"));
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			int role_id = Integer.parseInt(request.getParameter("role_id"));

			UserRole pro = new UserRole(user_role_id, user_id, role_id);
			try {
				UserRoleDao.updateUserRole(pro);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/UserRoleManage");
		}
	}
}
