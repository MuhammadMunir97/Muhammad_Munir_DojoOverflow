<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Please Enter Your Question</title>
</head>
<body>
<h1>What is your question?</h1>

<form:form action="/questions" method="POST" modelAttribute="Question">
	<p>
        <form:label path="mainQuestion">Question</form:label>
        <form:errors path="mainQuestion"/>
        <form:textarea path="mainQuestion"/>
    </p>
    <p>
	<label>Tags: <input type="text" name="myTags"></label>
	</p>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>