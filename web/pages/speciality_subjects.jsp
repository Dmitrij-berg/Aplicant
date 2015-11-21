<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Speciality subjects</title>
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
<h1>Speciality subjects</h1>
<c:if test="${specialitySubjects.size() == 0}">
  No speciality subjects
</c:if>
<table>
  <tr>
    <th>Speciality subject Id</th>
    <th>Subject</th>
    <th>Profession</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${specialitySubjects}" var="specialitySubject">
    <tr>
      <td><c:out value="${specialitySubject.getId()}"/></td>
      <td><c:out value="${specialitySubject.getSubject()}"/></td>
      <td><c:out value="${specialitySubject.getProfession()}"/></td>
      <td><a href="controller?command=deleteSpecialitySubject&id=${specialitySubject.getId()}"><img src="img/delete.jpg" alt="del"></a>
        <a href="controller?command=editSpecialitySubject&id=${specialitySubject.getId()}"><img src="img/edit.jpg" alt="edit"></a></td>
    </tr>
  </c:forEach>
</table>
<div>
  <a href="controller?command=addSpecialitySubject"><img src="img/add.jpg" alt="add"></a>
</div>

</body>
</html>