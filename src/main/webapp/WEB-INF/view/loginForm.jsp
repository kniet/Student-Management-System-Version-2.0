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
        <form action="checkLogin" method="POST">
            <ul class="list">
                <li><h2>Welcome</h2></li>
                <li><p>${errorMsg}</p></li>
                <li><input type="text" name="Username" placeholder="Username"/></li>
                <li><input type="password" name="Password" placeholder="Password"/></li>
                <li><input type="submit" value="LOGIN"/></li>
            </ul>
        </form>
    </div>
</body>
</html>
