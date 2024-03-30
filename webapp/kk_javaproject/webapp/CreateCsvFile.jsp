<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.java_project.model.Customer"%>
<%
	String admin = (String) session.getAttribute("admin");

	if( admin == null) {
		response.sendRedirect("login.jsp");
		return;
	}

	String error = (String) request.getAttribute("error");
	List<Customer> list = (List<Customer>) request.getAttribute("CustomerList");
	
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
		<title>CSV出力</title>
	</head>
	<body>
		<header>
			<jsp:include page="nav_javaproject.jsp" />
		</header>
		<h1 class="text-center mt-5">CSVファイルへ出力</h1>
		<form action="create_csv" class="text-center container" method="post">
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
				<p class="mt-3">CSV出力するデータを選択してください</p>
			<%
					for(Customer cst : list) {
						
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
				</table>
			</div>
			<div class="row">
				<div class="col-5 mx-auto">
					<label for="csv_file_name" class="form-label mt-1" style="font-size:20px">ファイル名を入力してください</label>
					<input type="text" class="form-control" name="csv_file_name" id="csv_file_name">
				</div>
				<div class="col-5 mt-5 mx-auto">
					<input type="submit" class="btn btn-primary w-25" value="CSV出力">
				</div>
			</div>
		</form>
	</body>
</html>