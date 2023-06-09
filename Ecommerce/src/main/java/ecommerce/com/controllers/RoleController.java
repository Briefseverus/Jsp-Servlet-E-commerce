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

import ecommerce.com.daos.RoleDao;
import ecommerce.com.models.Role;

@WebServlet("/RoleManage")
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RoleDao proDao = new RoleDao();
			List<Role> pros = proDao.getAllRole();
			request.setAttribute("pros", pros);
			request.getRequestDispatcher("RoleManage.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}