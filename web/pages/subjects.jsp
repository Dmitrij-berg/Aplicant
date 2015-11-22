
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Subjects</title>
  <style>
    <%@include file='style.css' %>
  </style>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<body>
<div class="header">
  <h2><a class="header-link" href="/app">Main Dashboard</a></h2>
</div>
<h1>Subjects</h1>
<c:if test="${subjects.size() == 0}">
  No subjects
</c:if>
<table>
  <tr>
    <th>Subject Id</th>
    <th>Subject Name</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${subjects}" var="subject">
    <tr>
      <td><c:out value="${subject.getId()}"/></td>
      <td><c:out value="${subject.getSubjectName()}"/></td>
      <td><a href="controller?command=deleteSubject&id=${subject.getId()}"><img src="img/delete.jpg" alt="del"></a>
          <a href="controller?command=editSubject&id=${subject.getId()}"><img src="img/edit.jpg" alt="edit"></a></td>
    </tr>
  </c:forEach>
</table>
<div>
  <a href="controller?command=addSubject"><img src="img/add.jpg" alt="add"></a>
</div>

</body>
</html>
