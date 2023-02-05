<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addOrUpdate.css">
  <title>Update student</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/StudentSmall.png" alt="logo">
<div class="wrapper">
  <div class="header">
    <h1>Alter student</h1>
  </div>
</div>
<div class="container">
  <div class="table">
    <form:form action="updateStudent" modelAttribute="student" method="post">
      <form:hidden path="id"/>
        <table>
          <tbody>
            <tr>
              <td><label>First name:</label></td>
              <td><form:input path="firstName"/></td>
              <td><form:errors path="firstName" cssClass="errorMsg"/></td>
            </tr>
            <tr>
              <td><label>Last name:</label></td>
              <td><form:input path="lastName"/></td>
              <td><form:errors path="lastName" cssClass="errorMsg"/></td>
            </tr>
            <tr>
              <td><label>Student book:</label></td>
              <td><form:input path="studentBook"/></td>
              <td><form:errors path="studentBook" cssClass="errorMsg"/>
                <c:if test="${not empty updateError}">
                  <p class="errorMsg">${updateError}<p>
                </c:if>
              </td>
            </tr>
            <tr>
              <td><label>Class group:</label></td>
              <td><form:input path="classGroup"/></td>
              <td><form:errors path="classGroup" cssClass="errorMsg"/></td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" value="Save" class="save"/></td>
              <td></td>
            </tr>
          </tbody>
        </table>
    </form:form>
    <div style="clear: both"></div>
    <p>
      <a href="${pageContext.request.contextPath}/AdminPanel/">Back to list</a>
    </p>
  </div>
</div>
</body>
</html>
