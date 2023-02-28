<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginForm.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <title>Login</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}/resources/images/StudentSmall.png" alt="logo">
    <div class="container">
        <form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
            <ul class="list">
                <li><h2>Welcome</h2></li>
                <li>
                    <c:if test="${param.error != null}">
                        <p>Invalid username and password.</p>
                    </c:if>

                    <c:if test="${param.logout != null}">
                        <p>You have been logged out.</p>
                    </c:if>
                </li>
                <li><input type="text" name="username" placeholder="Username"/></li>
                <li><input type="password" name="password" placeholder="Password"/></li>
                <li><input type="submit" value="LOGIN"/></li>
            </ul>
        </form:form>
        <div class="registerDiv">
            <a href="${pageContext.request.contextPath}/register/showRegistrationForm" class="register">REGISTER</a>
        </div>
    </div>
</body>
</html>
