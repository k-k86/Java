package com.login.java_project.controller;

import java.io.IOException;

import com.login.java_project.Login;
import com.login.java_project.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		String admin_id = request.getParameter("admin_id");
		String admin_pass = request.getParameter("password");
		
		Login login = new Login();
		LoginDao.getAdminUser(admin_id, admin_pass);
		
		
		if(login.getLoginFlag()) {
			
			HttpSession session = request.getSession();
			session.setAttribute("admin", login.getId());
			session.setAttribute("pass", login.getPass());
			
			request.getRequestDispatcher("homepage.jsp").forward(request, response);
			
		} else {
			System.out.println("ログイン失敗");
			String message = "IDとパスワードをお確かめください。";
			request.setAttribute("mess", message);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	
	}

}
