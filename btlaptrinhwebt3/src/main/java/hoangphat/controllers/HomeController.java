package hoangphat.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/home","/trangchu"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = -5239443831057636103L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printW = resp.getWriter();
        printW.println("hello world");
        printW.close();
//		resp.setContentType("text/html");
//		String ten = req.getParameter("ten");
//		String holot = req.getParameter("holot");
//		PrintWriter printW = resp.getWriter();
//		printW.println(holot + " " + ten);
//		printW.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
