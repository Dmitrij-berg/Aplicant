<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 14.09.15
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Applicant results</title>
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
<h1>Applicant results</h1>
<c:choose>
    <c:when test="${applicant_results.size() == 0}">
        <p><c:out value="No applicant results yet"></c:out></p>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <th>Applicant result id</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Subject Name</th>
                <th>Entrance Year</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${applicant_results}" var="applicant_result">
                <tr>
                    <td>
                        <c:out value="${applicant_result.getId()}"/>
                    </td>
                        <%--добавил аппликанта--%>
                    <td>
                        <c:out value="${applicant_result.getApplicant().getLastName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant_result.getApplicant().getFirstName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant_result.getSubjectName()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant_result.getApplicant().getEntranceYear()}"/>
                    </td>
                    <td>
                        <c:out value="${applicant_result.getMark()}"/>
                    </td>
                    <td>
                        <a href="controller?command=deleteApplicant_result&id=${applicant_result.getId()}"><img src="img/delete.jpg" alt="del"></a>
                        <a href="controller?command=editApplicant_result&id=${applicant_result.getId()}"><img src="img/edit.jpg" alt="edit"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>
<a href="controller?command=addApplicant_result"><img src="img/add.jpg" alt="add"></a>
</body>
</html>