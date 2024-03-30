package com.java_project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.java_project.model.Customer;
import com.java_project.model.CustomerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerDeleteServlet
 */
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   response.setContentType("text/html; charset=UTF-8");
	   
	   HttpSession session = request.getSession();
	   
	   //更新ボタンか削除ボタンどちらが押されたか判別するための処理
	   String submit_check = request.getParameter("sub_check");
	   
	   if("検索".equals(submit_check)) {
		   request.getRequestDispatcher("customer_serach.jsp").forward(request, response);
	   }
	   
	   	
		//String admin = (String) session.getAttribute("admin");
		
		//jspでチェックされているvalueを配列に入れる。
		String[] key = request.getParameterValues("check");
		List<Customer> list = new ArrayList<>();
		
		//CSVファイルを出力するページに遷移するボタンが押されたとき
		if("CSV".equals(submit_check)) {
			
			list = CustomerDao.AllCustomerList();
			request.setAttribute("CustomerList", list);
			request.getRequestDispatcher("CreateCsvFile.jsp").forward(request, response);
			   
		}
		
		//削除、更新ボタン押下時にチェックボックスが一つも選択されていない時にエラー文を返す為の処理
		if(key == null) {
			
			list = CustomerDao.AllCustomerList();
			request.setAttribute("CustomerList", list);
			String error = "チェックボックスが選択されていません。";
			request.setAttribute("error", error);
			request.getRequestDispatcher("Customer_view.jsp").forward(request, response);
			
		}
		
		//String配列keyをInteger配列に変換する。(DELETE文やUPDATE文で処理するため)
		Integer[] customerKey = new Integer[key.length];
		for(int i = 0; i < key.length; i++) {
			customerKey[i] = Integer.parseInt(key[i]); 
		}
		
		
		//更新ボタンが押された処理
	   	if("更新".equals(submit_check)) {
	   		
	   		list = CustomerDao.SelectCustomerListById(customerKey);
	   		session.setAttribute("CustomerList", list);
	   		
	   		request.getRequestDispatcher("CustomerUpdate.jsp").forward(request, response);
	   		return;
	   	}
		//削除ボタンが押された処理
		if("削除".equals(submit_check)) {
			
			//顧客情報を削除するためのメソッド。countには削除件数が入る。
			Integer count = CustomerDao.DeleteCustomer(customerKey);
			
			list = CustomerDao.AllCustomerList();
			request.setAttribute("CustomerList", list);
			request.setAttribute("count", count);
			
			request.getRequestDispatcher("Customer_view.jsp").forward(request, response);
			
		}
		
	}
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   doPost(request, response);
	   
   }

}
