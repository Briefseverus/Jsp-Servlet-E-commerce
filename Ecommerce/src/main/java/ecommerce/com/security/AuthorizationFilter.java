package ecommerce.com.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.com.models.User;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
	 
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
 
        String path = req.getRequestURI().substring(req.getContextPath().length());
 
        if (path.contains("Manage")) {
            if (session == null || session.getAttribute("user") == null) {
                res.sendRedirect(req.getContextPath() + "/login");
            } else {
                User user = (User) session.getAttribute("user");
                if (user.getRole_id() != 1) {
                    res.sendRedirect(req.getContextPath() + "/access-denied.jsp");
                } else {
                    chain.doFilter(request, response);
                }
            }
        } else if (path.contains("Cart")) {
            if (session == null || session.getAttribute("user") == null) {
                res.sendRedirect(req.getContextPath() + "/login");
            } else {
                User user = (User) session.getAttribute("user");
                if (user.getRole_id() != 0 && user.getRole_id() != 1) {
                    res.sendRedirect(req.getContextPath() + "/access-denied.jsp");
                } else {
                    chain.doFilter(request, response);
                }
            }
        }else if (path.contains("Order")) {
            if (session == null || session.getAttribute("user") == null) {
                res.sendRedirect(req.getContextPath() + "/login");
            } else {
                User user = (User) session.getAttribute("user");
                if (user.getRole_id() != 0 && user.getRole_id() != 1) {
                    res.sendRedirect(req.getContextPath() + "/access-denied.jsp");
                } else {
                    chain.doFilter(request, response);
                }
            }
        } 
        else {
        	
        	
            chain.doFilter(request, response);
        }
    }
 
    public void init(FilterConfig filterConfig) {}
 
    public void destroy() {}
}
