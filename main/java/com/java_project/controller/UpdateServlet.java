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
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	response.setContentType("text/html; charset=UTF-8");
    	//HttpSession session = request.getSession();
    	String error = "";
    	
    	String[] customer_id = request.getParameterValues("check");
    	
    	if ( customer_id == null ) {
    		
    		error = "更新する顧客が選択されていません。";
    		request.setAttribute("error", error);
    		request.getRequestDispatcher("CustomerUpdate.jsp").forward(request, response);
    		
    	}
    	if( customer_id.length > 1 ) {
    		
    		error = "更新する顧客情報が1件以上選択されています。";
    		request.setAttribute("error", error);
    		request.getRequestDispatcher("CustomerUpdate.jsp").forward(request, response);
    		
    	}
    	
    	String birth = request.getParameter("update_birth");
    	String reg = request.getParameter("update_reg");
		String dFormat = "yyyy-MM-dd";
		LocalDate date_birth = null;
		LocalDate date_reg = null;
		
		if(!"".equals(birth)) {
			
			date_birth = LocalDate.parse(birth, DateTimeFormatter.ofPattern(dFormat));
			
		}
		if( !"".equals(reg) ) {
			
			date_reg = LocalDate.parse(reg, DateTimeFormatter.ofPattern(dFormat));
			
		}
	
		Customer cust = new Customer();
		//Customerのsetterに値をセット
		cust.setCustomer_name(request.getParameter("update_name"));
		cust.setCustomer_name_kana(request.getParameter("update_name_kana"));
		cust.setCustomer_sex(Integer.parseInt(request.getParameter("update_sex")));
		cust.setCustomer_birth_date(date_birth);
		cust.setCustomer_address(request.getParameter("update_address"));
		cust.setCustomer_tell(request.getParameter("update_tell"));
		cust.setCustomer_mail(request.getParameter("update_mail"));
		cust.setCustomer_reg_date(date_reg);
		
		//String配列keyをInteger配列に変換する。(DELETE文やUPDATE文で処理するため)
		Integer[] customerKey = new Integer[customer_id.length];
		for(int i = 0; i < customer_id.length; i++) {
			customerKey[i] = Integer.parseInt(customer_id[i]); 
		}
		
		List<Customer> list = CustomerDao.UpdateCustomer(customerKey, cust);
		
		request.setAttribute("List", list);
		request.setAttribute("error", error);
		request.getRequestDispatcher("UpdateResult.jsp").forward(request, response);
    	
	}

}
