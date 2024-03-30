package com.java_project.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.java_project.model.Customer;
import com.java_project.model.CustomerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerConditionsServlet
 */
public class CustomerConditionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		
		//HTMLのテキストボックスが何も値が入っていないときは、getParameterで受け取る際は""で入る。
		//radioボタンのname属性(customer_sex)で何も値が入っていない時のgetParameterで受け取る際はNULLになる。
		String name = request.getParameter("customer_name");
		String name_kana = request.getParameter("customer_name_kana");
		String address = request.getParameter("customer_address");
		String tell = request.getParameter("customer_tell");
		String mail = request.getParameter("customer_mail");
		String id1 = request.getParameter("customer_id1");
		//String id2 = request.getParameter("customer_id2");
		
		
		//ここが受け取る際に受け取る値がないとNULLになる。
		String sex = request.getParameter("customer_sex");
		
		String birth = request.getParameter("customer_birth");
		String reg_date = request.getParameter("customer_reg");
		
		
		//日付のフォーマット
		String dFormat = "yyyy-MM-dd";
		LocalDate date_birth = null;
		LocalDate date_reg = null;
		
		Customer cust = new Customer();
		
		//空文字判定
		if(!"".equals(name)) {
			cust.setCustomer_name(name);
		}
		if(!"".equals(name_kana)) {
			cust.setCustomer_name_kana(name_kana);
		}
		if(!"".equals(address)) {
			cust.setCustomer_address(address);
		}
		if(!"".equals(tell)) {
			cust.setCustomer_tell(tell);
		}
		if(!"".equals(mail)) {
			cust.setCustomer_mail(mail);
		}
		
		//String型で受け取った日付をLocalDate型に変換
		if(!"".equals(birth)) {
			date_birth = LocalDate.parse(birth, DateTimeFormatter.ofPattern(dFormat));
			cust.setCustomer_birth_date(date_birth);
		}
		//String型で受け取った日付をLocalDate型に変換
		 if(!"".equals(reg_date)) {
			date_reg = LocalDate.parse(reg_date, DateTimeFormatter.ofPattern(dFormat));
			cust.setCustomer_reg_date(date_reg);
		}
		 
		//String型で受け取ったidをparseIntで変換してセッターに送る。
		if(!"".equals(id1)) {
			cust.setCustomer_id(Integer.parseInt(id1));
		}
		//String型で受け取ったidをparseIntで変換してセッターに送る。
		if(sex != null){
			cust.setCustomer_sex(Integer.parseInt(sex));
		} 
		
		
		
		List<Customer> list = CustomerDao.CustomerConditionsSerach(cust);
		
		request.setAttribute("CustomerList", list);
		request.getRequestDispatcher("Customer_view.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("customer_serach.jsp");
	}

}
