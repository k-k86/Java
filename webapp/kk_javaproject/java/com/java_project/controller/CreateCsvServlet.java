package com.java_project.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
 * Servlet implementation class CreateCsvServlet
 */
public class CreateCsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html; charset=UTF-8");
    	HttpSession session = request.getSession();
    	
    	//jspでチェックされているvalueを配列に入れる。
    	String[] key = request.getParameterValues("check");
    	List<Customer> list = new ArrayList<>();
    			
    	//チェックボックスが一つも選択されていないとき
    	if(key == null) {
    				
    		list = CustomerDao.AllCustomerList();
    		request.setAttribute("CustomerList", list);
    		String error = "チェックボックスが選択されていません。";
    		request.setAttribute("error", error);
    		request.getRequestDispatcher("CreateCsvFile.jsp").forward(request, response);
    				
    	}
    			
    	//String配列keyをInteger配列に変換する。
    	Integer[] customerKey = new Integer[key.length];
    	for(int i = 0; i < key.length; i++) {
    		customerKey[i] = Integer.parseInt(key[i]); 
    	}
    	
    	String file_name = request.getParameter("csv_file_name");
    	StringBuilder sb = new StringBuilder();
    	
    	sb.append("C:\\usr\\csv\\");
    	sb.append(file_name);
    	
    	try {
    		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
    			new FileOutputStream(sb.toString(), false),"Shift-JIS")));
             
             pw.print("顧客ID");
             pw.print(",");
             pw.print("顧客名");
             pw.print(",");
             pw.print("顧客名(カナ)");
             pw.print(",");
             pw.print("性別");
             pw.print(",");
             pw.print("生年月日");
             pw.print(",");
             pw.print("住所");
             pw.print(",");
             pw.print("電話番号");
             pw.print(",");
             pw.print("メールアドレス");
             pw.print(",");
             pw.print("登録日");
             pw.print("\n");
             
             list = CustomerDao.SelectCustomerListById(customerKey);
             
             for(Customer cst : list) {
            	 
            	 pw.print(cst.getCustomer_id());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_name());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_name_kana());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_sex());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_birth_date());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_address());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_tell());
            	 pw.print(",");
            	 pw.print(cst.getCusotmer_mail());
            	 pw.print(",");
            	 pw.print(cst.getCustomer_reg_date());
            	 pw.print("\n");
             }
             
             // 出力確認用のメッセージ
             System.out.println("csvファイルを出力しました");
             
             // ファイルを閉じる
             pw.close();
             
             
    	} catch (IOException e) {
            e.printStackTrace();
        }
    	
    	list = CustomerDao.AllCustomerList();
		request.setAttribute("CustomerList", list);
		String error = "CSVファイルを出力しました。";
		request.setAttribute("error", error);
    	request.getRequestDispatcher("CreateCsvFile.jsp").forward(request, response);
		
	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.sendRedirect("CreateCsvFile");
    	
    }
}
