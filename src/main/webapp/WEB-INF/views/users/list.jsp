<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>
</head>
<body>
<main>
	<h2>사용자 목록</h2>
	<table>
		<tr>
			<td>UserID</td>
			<td>UserName</td>
			<td>Email</td>
			<td>Upoint</td>
			<td>RegDate</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
		<tr>
			<td colspan="7">
				[<a href="/Users/WriteForm">사용자등록</a>]&nbsp;&nbsp;&nbsp;
				[<a href="/">Home</a>]
			</td>
		</tr>
		
		<c:forEach var="user" items="${ userList }" >
		<tr>
			<td>${user.userid}</td>
			<td>${user.username }</td>
			<td>${user.email }</td>
			<td>${user.upoint }</td>
			<td>${user.regdate }</td>
			<td><a href="/Users/Delete?user=${user.userid}">삭제</a></td>
			<td><a href="/Users/UpdateForm?userid=${user.userid }"> 수정</a></td>
		</tr>
		</c:forEach>
	</table>
</main>
</body>
</html>