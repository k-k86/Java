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
	List<Customer> list = (List<Customer>) session.getAttribute("CustomerList");
	
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
		<title>更新画面</title>
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
	<h1 class="text-center mt-5">更新画面</h1>
		<form action="customer_update" class="text-center container" method="post">
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
				<p class="mt-3">更新したい情報を1件選択してください。</p>
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
				<div class="border col-10 mx-auto">
					<h3 class="text-center mb-3 mt-5">更新する項目を入力</h3>
					<% if ( error != null ) { %>
					<%= error %>
					<% } %>
					
					<div class="mb-2 row">
						<div class="col-5 mx-auto">
							<label for="customer_name" class="form-label mt-3 row-3" style="font-size:30px">顧客名</label>
							<input type="text" class="form-control" name="update_name" id="customer_name">
						</div>
						<div class="col-5 mx-auto">
							<label for="customer_name_kana" class="form-label mt-3" style="font-size:30px">顧客名(カナ)</label>
							<input type="text" class="form-control" name="update_name_kana">
						</div>
					</div>
					<div class="mb-2 row">
						<div class="form-group col-5 mx-auto">
							<div class="mt-4" style="font-size:30px">性別</div>
							<div class="mb-2 form-check form-check-inline">
								<Input type="radio" class="form-check-input" name="update_sex" id="man" value="1" style="transform:scale(1.2);">
								<label class="form-check-laebel" for="man">男</label>
							</div>
							<div class="mb-2 form-check form-check-inline">
								<Input type="radio" class="form-check-input" name="update_sex" id="woman" value="2" style="transform:scale(1.2);">
								<label class="form-check-label" for="woman">女</label>
							</div>
							<div class="mb-2 form-check form-check-inline">
								<input type="radio" class="form-check-input" name="update_sex" id="unknown" value="3" >
								<label class="form-check-label" for="unknown">不明</label>
							</div>
						</div>
						<div class="mb-2 col-5 mx-auto">
							<label for="customer_birth" class="form-label mt-3" style="font-size:30px">生年月日</label>
							<input type="date" class="form-control" name="update_birth" id="customer_birth" >
						</div>
					</div>
					<div class="mb-2 row">
						<div class="col">
							<label for="customer_address" class="form-label mt-3" style="font-size:30px">住所</label>
							<input type="text" class="form-control" name="update_address" id="customer_address" >
						</div>
						<div class="mb-2 col">
							<label for="customer_tell" class="form-label mt-3" style="font-size:30px">電話番号</label>
							<input type="text" class="form-control" name="update_tell" id="customer_tell" >
						</div>
					</div>
					<div class="mb-5 row">
						<div class="col">
							<label for="customer_mail" class="form-label mt-3" style="font-size:30px">メールアドレス</label>
							<input type="text" class="form-control" name="update_mail" id="customer_mail" >
						</div>
						<div class="col">
							<label for="customer_reg_date" class="form-label mt-3" style="font-size:30px">登録日</label>
							<input type="date" class="form-control" name="update_reg" id="customer_reg_date">
						</div>
					</div>
				</div>
					<input type="submit" class="btn btn-primary" value="更新">
			</form>

</body>
</html>