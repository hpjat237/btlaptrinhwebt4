package hoangphat.controllers;

import java.io.IOException;
import java.sql.Date;

import dao.impl.UserDaoImpl;
import hoangphat.service.IUserService;
import hoangphat.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.UserModel;
import ultis.Constant;

@WebServlet("/login")
public class LoginController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static IUserService service = new UserServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*
		 * HttpSession session = req.getSession(false); if (session != null &&
		 * session.getAttribute("account") != null) {
		 * resp.sendRedirect(req.getContextPath() + "/waiting"); return; } // Check
		 * cookie Cookie[] cookies = req.getCookies(); if (cookies != null) { for
		 * (Cookie cookie : cookies) { if (cookie.getName().equals("username")) {
		 * session = req.getSession(true); session.setAttribute("username",
		 * cookie.getValue()); resp.sendRedirect(req.getContextPath() + "/waiting");
		 * return; } } }
		 */
		req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// mã hóa UTF-8
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");

		// lấy tham số từ view
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("rememberme");

		// Xử lý bài toán
		String alertMsg = "";
		boolean isRememberMe = false;
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
		    alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
		    req.setAttribute("alert", alertMsg);
		    req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
		    return;
		}
		UserModel user = service.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/view/login.jsp").forward(req, resp);

		}
	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}
    public static void main(String[] args) {
    }
}
