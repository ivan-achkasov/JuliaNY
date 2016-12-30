<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href='<spring:url value="/css/question.css"/>'>
</head>
<body>
	<div id="countBadAnsw">
		<p>Неправильных ответов: ${countBadAnsw}</p>
	</div>
	<br />
	<div id="question">${question}</div>

	<form id="answer" action="testQuestion" method="GET">
		<input name="answer" type="text" class="answerItem"/>
		<br/>
		<button class="answerItem">Ответить</button>
	</form>

</body>
</html>