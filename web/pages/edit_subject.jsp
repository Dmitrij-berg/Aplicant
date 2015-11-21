<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Edit Subject</title>
  <style>
    <%@include file='style.css' %>
  </style>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<body>

<div class="header">
  <h2><a class="header-link" href="controller?command=subjects">Subjects</a></h2>
</div>

<form method="post" action="controller?command=saveSubject">

  <c:choose>
    <c:when test="${subject ne null}">
      <h1>Edit Subject</h1>
      <p>Subject Name</p>
      <input type="text" name="subject_name" autofocus required value="${subject.getSubjectName()}"/>
      <input type="hidden" name="subject_id" value="${subject.getId()}"/>
    </c:when>
    <c:otherwise>
      <h1>Add Subject</h1>
      <p>Subject Name</p>
      <input type="text" name="subject_name" autofocus required value=""/>
    </c:otherwise>
  </c:choose>
</form>
</body>
</html>