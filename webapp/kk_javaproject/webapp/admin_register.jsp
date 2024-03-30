<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	String admin = (String) session.getAttribute("admin");
	int level = (int) session.getAttribute("level");
	
	String message = (String)request.getAttribute("message");

	if( admin == null) {
		response.sendRedirect("login.jsp");
	}
	
	if(message == null){
		message = "";
	}
	
	if(level != 1) {
		response.sendRedirect("menu.jsp");
	}

%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
		<style>
			.form { text-align: center };
		</style>
		<title>管理者ユーザー追加</title>
	</head>
	<body>
		<header>
			<jsp:include page="nav_javaproject.jsp" />
		</header>
		<div class="form">
			<h1 style="padding-top:5%">管理者ユーザー追加</h1>
			<form action="admin_reg" class="" method="post">
				<div class="border col-4 mx-auto">
				<label for="admin_id" class="form-label mt-3" style="font-size:20px">管理者ユーザーID</label>
				<input type="text" id="admin_id" name="admin_reg_name" class="form-control w-75 mx-auto" title="登録する管理者IDを入力してください" required>
				<label for="admin_pass" class="form-label mt-3" style="font-size:20px">管理者ユーザーパスワード</label>
				<input type="text" id="admin_pass" class="form-control w-75 mx-auto mb-3" name="admin_reg_pass" title="登録する管理者パスワードを入力してください" required>
				
				<label class="form-label" style="font-size:20px">管理権限範囲</label><br>
				<select name="admin_reg_level" class="mb-3 w-50" title="管理権限の範囲を設定してください" required>
					<option value="">管理権限範囲</option>
					<option value="1">全権限付与</option>
					<option value="2">一部権限付与</option>
				</select>
				</div>
				<input type="submit" class="btn btn-primary mt-3 w-25" value="管理者ユーザーを追加">
			</form>
			<p><h3><%= message %></h3></p>
		</div>
	</body>
</html>