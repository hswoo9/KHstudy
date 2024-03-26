<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<c:set var="path" value="${ pageContext.request.contextPath }" />

<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!  
	</h1>
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<security:authorize access="isAnonymous()">
		<a href="${ path }/login">로그인</a>
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<h2>관리자님 어서오세요~!</h2>
	</security:authorize>
	
	<security:authorize access="isAuthenticated()">
		<p><security:authentication property="principal.username"/>님 안녕하세요.</p>
		
		<form action="${ path }/logout" method="POST">
			<input type="submit" value="로그아웃">
			<security:csrfInput/>
		</form>
	</security:authorize>
</body>
</html>
