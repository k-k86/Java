package com.java_project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.java_project.model.Customer;
import com.java_project.model.CustomerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerRegisterServlet
 */
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String error = "";
		Integer rows = null;
		//String error = "";
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			
			LocalDate date_birth = null;
			String birth = request.getParameter("customer_birth");
			String dFormat = "yyyy-MM-dd";
			
			if(!"".equals(birth)) {
				date_birth = LocalDate.parse(birth, DateTimeFormatter.ofPattern(dFormat));
			}
			
		
			Customer cust = new Customer();
			//Customerのsetterに値をセット
			cust.setCustomer_name(request.getParameter("customer_name"));
			cust.setCustomer_name_kana(request.getParameter("customer_name_kana"));
			cust.setCustomer_sex(Integer.parseInt(request.getParameter("r_btn")));
			cust.setCustomer_birth_date(date_birth);
			cust.setCustomer_address(request.getParameter("customer_address"));
			cust.setCustomer_tell(request.getParameter("customer_tell"));
			cust.setCustomer_mail(request.getParameter("customer_mail"));
			
			rows = CustomerDao.InsertCustomer(cust);
/**
			var date_format = new SimpleDateFormat("yyyy年MM月dd日");
			var today = LocalDateTime.now();
			String today_format = date_format.format(today);

			var today = LocalDateTime.now();
			request.setAttribute("name", request.getParameter("customer_name"));
			request.setAttribute("name_kana", request.getParameter("customer_name_kana"));
			request.setAttribute("sex", request.getParameter("r_btn"));
			request.setAttribute("birth", request.getParameter("customer_birth"));
			request.setAttribute("address", request.getParameter("customer_address"));
			request.setAttribute("tell", request.getParameter("customer_tell"));
			request.setAttribute("mail", request.getParameter("customer_mail"));
			request.setAttribute("date",  today);
*/
			session.setAttribute("count", rows);
			response.sendRedirect("reg_customer.jsp");
			
		} catch(DateTimeParseException e) {
			
			error = "入力情報が間違っています。";
			request.setAttribute("error", error);
			request.getRequestDispatcher("reg_customer.jsp").forward(request, response);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("reg_customer.jsp");
	}

}
