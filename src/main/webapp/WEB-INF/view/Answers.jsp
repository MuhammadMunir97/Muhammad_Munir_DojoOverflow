<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${question.mainQuestion}</h1>
<c:forEach items="${question.tags}" var="tag">
	${tag.subject}
</c:forEach>

<form:form action="/answers/${question.id}" method="POST" modelAttribute="Answer">
	<p>
        <form:label path="mainAnswer">Answer</form:label>
        <form:errors path="mainAnswer"/>
        <form:textarea path="mainAnswer"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>

<table>
    <thead>
        <tr>
            <th><h3>Answers</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${question.answers}" var="ans">
        <tr>
        	<td><c:out value="${ans.mainAnswer}"/></a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>


</body>
</html>