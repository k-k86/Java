<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String admin = (String) session.getAttribute("admin");

	if( admin == null) {
		response.sendRedirect("login.jsp");
		return;
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			.serach_customer { text-align: center; }
		</style>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<title>顧客情報検索</title>
	</head>
	<body>
		<header>
			<jsp:include page="nav_javaproject.jsp" />
		</header>
		<h1 class="text-center mt-5 mb-3">顧客情報検索</h1>
		<div class="border col-8 mx-auto">
			<form action="CustomerSerachWhere" class="text-center container" method="post">
				<div class="mb-2 row">
					<label for="customer_id" class="form-label mt-3 row-3" style="font-size:30px">顧客ID</label>
					<div class="col">
						<input type="text" class="form-control w-25 mx-auto" name="customer_id1">
					</div>
<%--
					<div class="col">
						～
					</div>
					<div class="col me-5">
						<input type="text" class="form-control me-5" name="customer_id2">
					</div>
 --%>
				</div>
				<div class="mb-2 row">
					<div class="col">
						<label for="customer_name" class="form-label mt-3 row-3" style="font-size:30px">顧客名</label>
						<input type="text" class="form-control" name="customer_name" id="customer_name">
					</div>
					<div class="col">
						<label for="customer_name_kana" class="form-label mt-3" style="font-size:30px">顧客名(カナ)</label>
						<input type="text" class="form-control" name="customer_name_kana">
					</div>
				</div>
				<div class="mb-2 row">
					
					<div class="form-group col">
					<div class="mt-4" style="font-size:30px">性別</div>
						<div class="mb-2 form-check form-check-inline">
							<Input type="radio" class="form-check-input" name="r_btn" id="man" value="1" style="transform:scale(1.2);">
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
					<div class="mb-2 col">
						<label for="customer_birth" class="form-label mt-3" style="font-size:30px">生年月日</label>
						<input type="date" class="form-control" id="customer_birth" name="customer_birth" >
					</div>
				</div>
				<div class="mb-2 row">
					<div class="col">
						<label for="customer_address" class="form-label mt-3" style="font-size:30px">住所</label>
						<input type="text" class="form-control" name="customer_address" id="customer_address" >
					</div>
					<div class="mb-2 col">
						<label for="customer_tell" class="form-label mt-3" style="font-size:30px">電話番号</label>
						<input type="text" class="form-control" name="customer_tell" id="customer_tell" >
					</div>
				</div>
				<div class="mb-5 row">
					<div class="col">
						<label for="customer_mail" class="form-label mt-3" style="font-size:30px">メールアドレス</label>
						<input type="text" class="form-control" name="customer_mail" id="customer_mail" >
					</div>
					<div class="col">
						<label for="customer_reg_date" class="form-label mt-3" style="font-size:30px">登録日</label>
						<input type="date" class="form-control" name="customer_reg" id="customer_reg_date">
				</div>
			</div>
			<div class="text-center mt-3">
				<input type="submit"  class="btn btn-primary" value="検索">
				<input type="reset" class="btn btn-primary" value="リセット">
			</div>
		</form>
	</body>
</html>