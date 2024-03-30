<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.java_project.model.Customer"%>
<%
	String admin = (String) session.getAttribute("admin");

	if( admin == null) {
		response.sendRedirect("login.jsp");
	}

	List<Customer> list = (List<Customer>) request.getAttribute("List");

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
		<title>更新結果</title>
	</head>
	<body>
		<h1 class="mt-5 mb-5" style="text-align:center">更新結果</h1>
		<div class="container-fluid">
			<div class="border col-10 mx-auto">
<%
	if( list != null ) {
		for(Customer cst : list) {

			if(MAN.equals(cst.getCustomer_sex()) ) {
				gender = "男";
			} else if(WOMAN.equals(cst.getCustomer_sex()) ) {
				gender = "女";
			} else {
				gender = "不明";
			}

%>
			<main class="col-10 mx-auto">
				<h3 class="mt-5" style="text-align:center">以下の情報を更新しました</h2>
				<div class="row mt-5 mb-3">
					<div class="col-3">顧客ID:</div>
					<div class="col-7 border col-7"><%= cst.getCustomer_id() %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">顧客名:</div>
					<div class="col-7 border col-7"><%= cst.getCustomer_name() %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">顧客名(カナ):</div>
					<div class="col-7 border col-7"><%= cst.getCustomer_name_kana() %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">性別</div>
					<div class="col-7 border col-7"><%= gender %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">生年月日</div>
					<div class="col-7 border col-7"><%= cst.getDateFormat( cst.getCustomer_birth_date() ) %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">住所</div>
					<div class="col-7 border col-7"><%= cst.getNotNullCheck(cst.getCustomer_address()) %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">電話番号</div>
					<div class="col-7 border col-7"><%= cst.getNotNullCheck(cst.getCustomer_tell()) %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">メールアドレス</div>
					<div class="col-7 border col-7"><%= cst.getNotNullCheck(cst.getCusotmer_mail()) %></div>
				</div>
				<div class="row mb-3">
					<div class="col-3">登録日</div>
					<div class="col-7 border col-7"><%= cst.getDateFormat( cst.getCustomer_reg_date() )%></div>
				</div>
			</main>
<% 		} %>
			
<% 	} else {%>
		<h3 class="mt-5 my-5" style="text-align:center; color:red">更新した項目はありません。</h3>
<%	} %>
			</div>
		</div>
		<div class="mt-5" >
		<form action="CustomerUpdate.jsp" method="post" class="text-center" >
				<input type="submit" id="" class="btn btn-primary w-25"  value="戻る">
		
		</form>
			</div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
	</body>
</html>