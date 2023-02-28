<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginForm.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <title>Register</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/StudentSmall.png" alt="logo">
<div class="container">
    <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
               modelAttribute="myUser">
        <ul class="list">
            <li><h2>Register new User</h2></li>
            <li>
                <c:if test="${registrationError != null}">
                    <p>${registrationError}</p>
                </c:if>
            </li>
            <li><form:input placeholder="Username" path="userName"/></li>
            <li><form:password placeholder="Password" path="password"/></li>
            <li><input type="submit" value="REGISTER"/></li>
        </ul>
    </form:form>
</div>
</body>
