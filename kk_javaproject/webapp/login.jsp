<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	String message = (String) request.getAttribute("mess");

	if(message == null) {
		message = "";
	}

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<title>ログイン画面</title>
	
	<style>
		.error { color:red };
	</style>
</head>
<body>
	<div class="mx-auto mt-5 text-center" id="test" style="width:300px;">
		<h1 class="mb-4 mt-5" style="text-align: center">ログイン画面</h1>
		<form action="login_serv" method="post">
			<div class="mb-3">
		    	<label for="adminID" class="form-label">管理者ID</label>
		    	<input type="text" class="form-control" id="adminID" name="admin_id">
		  	</div>
		  	<div class="mb-3">
		    	<label for="pass" class="form-label">パスワード</label>
		    	<input type="password" class="form-control" id="pass" name="password">
		  	</div>
		  	<div class="text-center">
		  		<button type="submit" class="btn btn-primary">ログイン</button>
		  	</div>
		</form>
		<div class="error">
			<h5 class="text-center mt-1"><%= message %></p>
		</div>
	</div>
</body>
</html>