<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${message} <br>
	<c:if test="${member == null}">
		<a href="join_init">[회원가입]</a>
		<a href="login_init">[로그인]</a>
	</c:if>

	<c:if test="${member != null}">
				    	{member.id}님 반갑습니다.
				    	<a href="user_logout">[로그아웃]</a>
				    	<a href="mainPage">메인으로가기</a>
	</c:if>
	<br>
</body>
</html>