<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String admin = (String) session.getAttribute("admin");
	String pass = (String) session.getAttribute("pass");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>
	<h1>ログイン成功</h1>
	<table>
		<tr>
			<td>ユーザーID:<%= admin %> </td>
		</tr>
		<tr>
			<td>パスワード:<%= pass %></td>
		</tr>
	</table>
	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>