package com.java_project.controller;

import java.io.IOException;

import com.java_project.model.AdminRegisterDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminRegServlet
 */
public class AdminRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		String admin_reg_id = request.getParameter("admin_reg_name");
		String admin_reg_pass = request.getParameter("admin_reg_pass");
		int admin_reg_level = Integer.parseInt(request.getParameter("admin_reg_level"));
		
		//パスワードハッシュ化
		String hash_pass = AdminRegisterDao.HashAdminPass(admin_reg_pass);
		String mess = AdminRegisterDao.InsertAdmin(admin_reg_id, hash_pass, admin_reg_level);
		
		request.setAttribute("message", mess);
		
		request.getRequestDispatcher("admin_register.jsp").forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		response.sendRedirect("admin_register.jsp");
		
	}

}
