<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Edit Applcant Result</title>
  <style>
    <%@include file='style.css' %>
  </style>
</head>
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<body>

<div class="header">
  <h2><a class="header-link" href="controller?command=applicant_results">Applicant result</a></h2>
</div>

<form method="post" action="controller?command=saveApplicant_result">

  <c:choose>

    <c:when test="${applicant_result ne null}">
      <h1>Edit applicant result</h1>
      <p>Applicant</p>
      <%--<input type="text" name="applicant_id" value="${applicant_result.getApplicantId()}"/>--%>

      <select name="applicant_id">
        <c:forEach items="${applicants}" var="applicant">
          <option value="${applicant.getId()}"><c:out value="${applicant.getFirstName()} ${applicant.getLastName()}"/></option>
        </c:forEach>
      </select>

      <p>Subject</p>
      <%--<input type="text" name="subject_id" value="${applicant_result.getSubjectId()}"/>--%>

      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>

      <p>Mark</p>
      <input type="number" min = "1" max = "12" name="mark" autofocus required value="${applicant_result.getMark()}"/>
      <input type="hidden" name="applicant_result_id" value="${applicant_result.getId()}"/>
      <p></p>
      <input type="submit"name="accept_button" value="click me!">

    </c:when>

    <c:otherwise>
      <h1>Add applicant result</h1>
      <%--<input type="text" name="applicant_id" value="${applicant_result.getApplicantId()}"/>--%>

      <select name="applicant_id">
        <c:forEach items="${applicants}" var="applicant">
          <option value="${applicant.getId()}"><c:out value="${applicant.getFirstName()} ${applicant.getLastName()}"/></option>
        </c:forEach>
      </select>

      <p>Subject</p>
      <%--<input type="text" name="subject_id" value="${applicant_result.getSubjectId()}"/>--%>

      <select name="subject_id">
        <c:forEach items="${subjects}" var="subject">
          <option value="${subject.getId()}"><c:out value="${subject.getSubjectName()}"/></option>
        </c:forEach>
      </select>
      <p>Mark</p>
      <input type="number" min = "1" max = "12" name="mark" autofocus required value=""/>
      <p></p>
      <input type="submit"name="accept_button" value="click me!">
    </c:otherwise>

  </c:choose>

</form>
</body>
</html>