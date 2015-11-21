<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Professions</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<style>
    <%@include file='style.css' %>
</style>

<body>
<div class="header">
    <h2><a class="header-link" href="/app">Main Dashboard</a></h2>
</div>

<h1>Professions</h1>
<c:if test="${professions.size() == 0}">
    No professions
</c:if>
<table>
    <tr>
        <th>Profession Id</th>
        <th>Profession Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${professions}" var="profession">
        <tr>
            <td><c:out value="${profession.getId()}"/></td>
            <td><c:out value="${profession.getProfessionName()}"/></td>
            <td><a href="controller?command=deleteProfession&id=${profession.getId()}"><img src="img/delete.jpg" alt="del"></a>
                <a href="controller?command=editProfession&id=${profession.getId()}"><img src="img/edit.jpg" alt="edit"></a></td>
        </tr>
    </c:forEach>
</table>
<div>
    <a href="controller?command=addProfession"><img src="img/add.jpg" alt="add"></a>
</div>

</body>
</html>
