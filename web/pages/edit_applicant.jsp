<%@ page import="org.sourceit.entities.Profession" %>
<%@ page import="java.util.List" %>
<%@ page import="org.sourceit.db.ApplicantDBProvider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit applicant</title>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
    <%@include file='style.css' %>
</style>
<body>
<div class="header">
    <h2><a class="header-link" href="controller?command=applicants">Applicant</a></h2>
</div>

<form method="post" action="controller?command=saveApplicant">

    <c:choose>

        <c:when test="${applicant ne null}">
            <h1>Edit applicant</h1>

            <p>First Name</p>
            <input type="text" name="first_name" autofocus required value="${applicant.getFirstName()}"/>

            <p>Last Name</p>
            <input type="text" name="last_name" autofocus required value="${applicant.getLastName()}"/>

            <p>Entrance Year</p>
            <input type="number" min="1950" max="2015" size = "5" name="entrance_year" value="${applicant.getEntranceYear()}"/>

            <p>Profession Name</p>
            <%--<input type="text" name="profession_id" value="${applicant.getProfessionId()}"/>--%>

            <select name="profession_id">
                <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
                </c:forEach>
            </select>


            <input type="hidden" name="applicant_id" value="${applicant.getId()}"/>

            <p></p>
            <input type="submit" name="accept_button" value="click me!">

        </c:when>

        <c:otherwise>
            <h1>Add applicant</h1>

            <p>First Name</p>
            <input type="text" autofocus required name="first_name" value=""/>

            <p>Last Name</p>
            <input type="text" autofocus required name="last_name" value=""/>

            <p>Entrance Year</p>
            <input type="number" min="1950" max="2015" size = "5" name="entrance_year" value=""/>

            <p>Profession Name</p>
            <%--<input type="text" name="profession_id" value=""/>--%>

            <select name="profession_id">
                <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
                </c:forEach>
            </select>

            <p></p>

            <input type="submit" name="accept_button" value="click me!">
        </c:otherwise>

    </c:choose>

</form>
</body>
</html>