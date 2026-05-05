<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menus List</title>
<link href="/css/common.css" rel="stylesheet">
<style>
table { 
	width : 100%;
}
td {
	padding : 5px;
	text-align : center;
}
#tr1 {
	background-color : black;
	color : white;
	td {
	border : 1px solid white;
	}
}

tr : nth-of-type(2) td {
	text-align : center;
	padding-right : 20px;
}

main { margin-bottom : 150px; }

</style>
</head>
<body>
	<h2>메뉴 목록</h2>
	<table>
		<tr id="tr1">
			<td>Menu_id</td>
			<td>Menu_name</td>
			<td>Menu_seq</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<tr>
			<td colspan="5">
				[<a href="/Menus/WriteForm"">메뉴등록</a>]&nbsp;&nbsp;&nbsp;
				[<a href="/Menus/WriteForm2">메뉴등록2</a>]&nbsp;&nbsp;&nbsp;
				[<a href="/">Home</a>]
			</td>
		</tr>
		<c:forEach var="menu" items="${menuList}">
			<tr>	
				<td>${ menu.menu_id }</td>
				<td>${ menu.menu_name }</td>
				<td>${ menu.menu_seq }</td>
				<td><a href="/Menus/Delete?menu_id=${ menu.menu_id }">삭제</a></td>
				<td><a href="/Menus/UpdateForm?menu_id=${ menu.menu_id }">수정</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>