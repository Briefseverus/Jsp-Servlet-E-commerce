package ecommerce.com.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.com.daos.UserDao;
import ecommerce.com.models.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    String username = request.getParameter("username");
		    String password = request.getParameter("password");

		    try {
		        User user = UserDao.authenticate(username, password);
		        if (user != null) {
		            HttpSession session = request.getSession();
		            session.setAttribute("user", user);
		            int roleId = user.getRole_id();
		            if (roleId == 0) {
		                response.sendRedirect(request.getContextPath() + "/HomeDisplay.jsp");
		            } else if (roleId == 1) {
		                response.sendRedirect(request.getContextPath() + "/ProductController.jsp");
		            }
		        } else {
		            request.setAttribute("errorMessage", "Invalid username or password");
		            request.getRequestDispatcher("login.jsp").forward(request, response);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		        request.setAttribute("errorMessage", "Unable to authenticate user. Please try again later.");
		        request.getRequestDispatcher("login.jsp").forward(request, response);
		    }
		}

}
