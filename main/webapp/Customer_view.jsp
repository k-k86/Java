<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.java_project.model.Customer"%>

<%

	String admin = (String) session.getAttribute("admin");

	if( admin == null) {
		response.sendRedirect("login.jsp");
	}
	
	List<Customer> list = (List<Customer>) request.getAttribute("CustomerList");
	Integer count = (Integer) request.getAttribute("count");
	String error = (String) request.getAttribute("error"); 
	String gender = "";
	final Integer MAN = 1;
	final Integer WOMAN = 2;
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

		<title>従業員一覧</title>
<%-- 
		<style>

			table, tr, th, td {
				border: 1px solid;
				border-collapse: collapse;
				padding: 5px 10px 5px 10px;
			}
			
			th {
				color: white;
				border-color: black;
				background-color: steelblue;
			}

		</style>
--%>
	</head>
		<body>
			<header>
				<jsp:include page="nav_javaproject.jsp" />
			</header>
	
			<h1 class="text-center mt-5">顧客情報一覧</h1>
			
				
			<form action="delete_customer" method="post">
			<div class="text-end me-5 mt-3 ">
				<input type="submit" class="btn btn-primary col-auto" name="sub_check" value="CSV">
				<input type="submit" class="btn btn-primary col-auto" name="sub_check" value="検索">
				<input type="submit" class="btn btn-primary col-auto" name="sub_check" value="更新">
				<input type="submit" class="btn btn-primary col-auto" name="sub_check" value="削除">
			</div>
		<% if(count != null) { %>
		<%= count %>件のデータを削除しました。
		<% } %>
		<% if(error != null) { %>
		<%= error %>
		<% } %>
			<div class="col-11 mx-auto">
				<table class="table table-dark table-striped mt-3">
					<thead class="text-center">
						<tr>
							<th scope="col"></th>
							<th scope="col">顧客番号</th>
							<th scope="col">氏名</th>
							<th scope="col">氏名(カナ)</th>
							<th scope="col">性別</th>
							<th scope="col">生年月日</th>
							<th scope="col">住所</th>
							<th scope="col">電話番号</th>
							<th scope="col">メールアドレス</th>
							<th scope="col">登録日</th>
						</tr>
					</thead>
			<% 
				if(list != null) {

					for(Customer cst : list) {
			%>
			<%  
						if(MAN.equals(cst.getCustomer_sex()) ) {
							gender = "男";
						} else if(WOMAN.equals(cst.getCustomer_sex()) ) {
							gender = "女";
						} else {
							gender = "不明";
						}
				
				%>
					<tbody>
						<tr>
							<th scope="row"><input type="checkbox" name="check" value="<%= cst.getCustomer_id() %>" ></th>
							<td align="center"><%= cst.getCustomer_id() %></td>
							<td align="center"><%= cst.getCustomer_name() %></td>
							<td align="center"><%= cst.getCustomer_name_kana() %></td>
							<td align="center"><%= gender %></td>
							<td><%= cst.getDateFormat( cst.getCustomer_birth_date() ) %></td>
							<td align="center"><%= cst.getNotNullCheck(cst.getCustomer_address()) %></td>
							<td align="center"><%= cst.getNotNullCheck(cst.getCustomer_tell()) %></td>
							<td><%= cst.getNotNullCheck(cst.getCusotmer_mail()) %></td>
							<td align="center"><%= cst.getDateFormat( cst.getCustomer_reg_date() ) %></td>
						</tr>
					</tbody>
				<% } %>
			<% } else {%>
				<p>検索条件に一致した項目はありません。</p>
			<% } %>
			</table>
			</div>
		</form>

	</body>
</html>