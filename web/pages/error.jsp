<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Applicant Error</title>
    <style>
        <%@include file='style.css' %>
    </style>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

<body>
<div>
    <h2><a class="header-link" href="/app">Main Dashboard</a></h2>
</div>
    <p>Sorry, but some your data is wrong</p>

  <c:out value="${error}"/>
</body>
</html>
