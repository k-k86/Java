<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate"%>
<%
	String admin = (String) session.getAttribute("admin");
	Integer result = (Integer) session.getAttribute("count");

	if( admin == null) {
		response.sendRedirect("login.jsp");
	}
	
	String error = (String) request.getAttribute("error");
	LocalDate today = LocalDate.now();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<meta charset="UTF-8">
		<title>顧客情報登録</title>
	</head>
	<body>
		<header>
			<jsp:include page="nav_javaproject.jsp" />
		</header>
		<p><h2 class="text-center mt-5 mb-5">顧客登録情報入力</h2></p>
	<% if(!"".equals(error) && error != null ) { %>
		<p style="text-color:red"><%= error %></p>
	<% } %>
	<% if( result != null ) { %>
		<p class="text-center">登録が完了しました。</p>
	<% } %>
	<div class="border col-10 mx-auto">
		<form action="customer_register" class="text-center container" method="post">
			<div class="text-end me-3 mt-2">*表記のある項目は必須入力です</div>
			<div class="mb-2">
				<label for="customer_name" class="form-label mt-3" style="font-size:30px">* 顧客名</label>
				<input type="text" class="form-control w-75 mx-auto" name="customer_name" id="customer_name" placeholder="顧客名を入力してください" required>
			</div>
			<div class="mb-2">
				<label for="customer_name_kana" class="form-label mt-3" style="font-size:30px">* 顧客名(カナ)</label>
				<input type="text" class="form-control w-75 mx-auto" name="customer_name_kana" placeholder="顧客名をカタカナで入力してください" required>
			</div>
				<p class="mt-2" style="font-size:30px">* 性別</p>
			<div class="form-group">
				<div class="mb-2 form-check form-check-inline">
					<Input type="radio" class="form-check-input" name="r_btn" id="man" value="1" checked style="transform:scale(1.2);">
					<label class="form-check-laebel" for="man">男</label>
				</div>
				<div class="mb-2 form-check form-check-inline">
					<Input type="radio" class="form-check-input" name="r_btn" id="woman" value="2" style="transform:scale(1.2);">
					<label class="form-check-label" for="woman">女</label>
				</div>
				<div class="mb-2 form-check form-check-inline">
					<input type="radio" class="form-check-input" name="r_btn" id="unknown" value="3" >
					<label class="form-check-label" for="unknown">不明</label>
				</div>
			</div>
			<div class="mb-2">
				<label for="customer_birth" class="form-label mt-3" style="font-size:30px">生年月日</label>
				<input type="date" class="form-control w-75 mx-auto" id="customer_birth" name="customer_birth" min="1800-01-01" max="<%= today %>" placeholder="生年月日を入力してください">
			</div>
			<div class="mb-2">
				<label for="customer_address" class="form-label mt-3" style="font-size:30px">住所</label>
				<input type="text" class="form-control w-75 mx-auto" name="customer_address" id="customer_address" placeholder="顧客の住所を入力してください">
			</div>
			<div class="mb-2">
				<label for="customer_tell" class="form-label mt-3" style="font-size:30px">* 電話番号</label>
				<input type="text" class="form-control w-75 mx-auto" name="customer_tell" id="customer_tell" placeholder="電話番号を入力してください">
			</div>
			<div class="mb-5">
				<label for="customer_mail" class="form-label mt-3" style="font-size:30px">メールアドレス</label>
				<input type="text" class="form-control w-75 mx-auto" name="customer_mail" id="customer_mail" placeholder="メールアドレスを入力してください">
			</div>
		</div>
		<div class="text-center mt-4">
			<input type="submit" class="btn btn-primary" value="登録" style="width:200px; height:50px">
		</div>
	</form>
</body>
</html>