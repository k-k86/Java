<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String admin = (String) session.getAttribute("admin");

	if( admin == null) {
		response.sendRedirect("login.jsp");
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<link href="menu.css" rel="stylesheet">
		<title>更新結果</title>
	</head>
	<body>
	<title>顧客管理システム</title>
	</head>
	<body>
		<header>
			<jsp:include page="nav_javaproject.jsp"/>
		</header>
			<div class="text-center">
			<h1 style="margin-top:100px">メニュー画面</h1>
			<div class="col-10 mx-auto mt-5">
				<a class="menu_in mx-auto mt-5" href="reg_customer.jsp"><div class="my-4">顧客情報登録</div></a>
				<a class="menu_in mx-auto my-5" href="customer_list"><div class="my-4">顧客情報一覧</div></a>
				<a class="menu_in mx-auto my-5" href="admin_register.jsp"><div class="my-4">管理者ユーザー追加</div></a>
			</div>
		
		<form action="logout" method="post">
			<div class="text-center">
			<input type="submit" btn="log_btn" class="btn btn-primary btn-lg" value="ログアウト">
			</div>
		</form>
		</div>
		</div>
	</body>
</html>