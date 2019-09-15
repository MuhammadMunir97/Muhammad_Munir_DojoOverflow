<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Questions</title>
</head>
<body>
<h1>Question Dashboard</h1> <br>
<a href="/questions/new">New Question</a>
<table>
    <thead>
        <tr>
            <th><h3>Question</h3></th>
            <th><h3>Tags</h3></th>
            <th><h3>Action</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questions}" var="question">
        <tr>
        	<td><a href="/answers/${question.id}"><c:out value="${question.mainQuestion}"/></a></td>
        	<td>
        	<c:forEach items="${question.tags}" var="tag">
        		${tag.subject} 
        	</c:forEach>
        	</td>
            <td>
            <form action="/questions/${question.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
			</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>