<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit speciality subject</title>
    <style>
        <%@include file='style.css' %>
    </style>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<body>

<div class="header">
    <h2><a class="header-link" href="controller?command=pspeciality_subjects">Speciality subjects</a></h2>
</div>

<form method="post" action="controller?command=saveSpecialitySubject">

    <c:choose>

        <c:when test="${specialitySubject ne null}">
            <h1>Edit speciality subject</h1>

            <p>Profession</p>
            <%--<input type="text" name="profession_id" value="${specialitySubject.getProfessionSubject()}"/>--%>
            <select name="profession_id">
                <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
                </c:forEach>
            </select>

            <p>Subject</p>
            <%--<input type="text" name="subject_id" value="${specialitySubject.getSubjectId()}"/>--%>
            <select name="subject_id">
                <c:forEach items="${subjects}" var="subject">
                    <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
                </c:forEach>
            </select>

            <input type="hidden" name="sp_sb_id" value="${specialitySubject.getId()}"/>

            <p></p>
            <input type="submit" name="accept_button" value="click me!">

        </c:when>

        <c:otherwise>
            <h1>Add speciality subject</h1>

            <p>Profession</p>
            <%--<input type="text" name="profession_id" value="${specialitySubject.getProfessionSubject()}"/>--%>
            <select name="profession_id">
                <c:forEach items="${professions}" var="profession">
                    <option value="${profession.getId()}"><c:out value="${profession.getProfessionName()}"/></option>
                </c:forEach>
            </select>

            <p>Subject</p>
            <%--<input type="text" name="subject_id" value="${specialitySubject.getSubjectId()}"/>--%>
            <select name="subject_id">
                <c:forEach items="${subjects}" var="subject">
                    <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
                </c:forEach>
            </select>

            <p>
                <input type="submit" name="accept_button" value="click me!">
            </p>
        </c:otherwise>

    </c:choose>

</form>
</body>
</html>