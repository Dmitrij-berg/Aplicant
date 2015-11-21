<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Edit profession</title>
  <style>
    <%@include file='style.css' %>
  </style>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<body>

<div class="header">
  <h2><a class="header-link" href="controller?command=professions">Professions</a></h2>
</div>


<h1>Add profession</h1>

<form method="post" action="controller?command=saveProfession">
  <p>Name</p>
  <c:choose>
    <c:when test="${profession ne null}">
      <input type="text" name="profession_name" autofocus required value="${profession.getProfessionName()}"/>
      <input type="hidden" name="profession_id" value="${profession.getId()}"/>
    </c:when>
    <c:otherwise>
      <input type="text" name="profession_name" value="" autofocus required/>
    </c:otherwise>
  </c:choose>
</form>
</body>
</html>