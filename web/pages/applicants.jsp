
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

  <title>Applicants</title>
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
<h1>Applicants</h1>

<c:choose>
  <c:when test="${applicants.size() == 0}">
    <p><c:out value="No applicants yet"></c:out></p>
  </c:when>
  <c:otherwise>
    <table>
      <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Profession Name</th>
        <th>Entrance Year</th>
        <th>Actions</th>
      </tr>
      <c:forEach items="${applicants}" var="applicant">
        <tr>
          <td>
            <c:out value="${applicant.getId()}"/>
          </td>
          <td>
            <c:out value="${applicant.getFirstName()}"/>
          </td>
          <td>
            <c:out value="${applicant.getLastName()}"/>
          </td>
          <td>
            <%--Изменил с профессионайди на просто профессион--%>
            <c:out value="${applicant.getProfession()}"/>
          </td>
          <td>
            <c:out value="${applicant.getEntranceYear()}"/>
          </td>
          <td>
            <a href="controller?command=deleteApplicant&id=${applicant.getId()}"><img src="img/delete.jpg" alt="del"></a>
            <a href="controller?command=editApplicant&id=${applicant.getId()}"><img src="img/edit.jpg" alt="edit"></a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:otherwise>
</c:choose>
<a href="controller?command=addApplicant"><img src="img/add.jpg" alt="add"></a>
</body>
</html>