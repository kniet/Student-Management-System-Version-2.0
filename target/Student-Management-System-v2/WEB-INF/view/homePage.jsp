<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainCss.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Home Page</title>
</head>
<body>
    <img src="${pageContext.request.contextPath}/resources/images/StudentSmall.png">
    <ul>
        <li><a class="active" href="${pageContext.request.contextPath}/HomePage/">Home page</a></li>
        <li><a href="${pageContext.request.contextPath}/AdminPanel/">Admin panel</a></li>
        <li><a href="${pageContext.request.contextPath}/">Logout</a></li>
    </ul>
    <c:if test="${empty students}">
        <div class="emptyStudent"><p>Students not found.</p></div>
    </c:if>
    <div class="container">
        <form:form cssClass="searchForm" action="search" method="get">
            <input type="text" placeholder="Search by surname or student book" name="searchedValue">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form:form>
       <table class="fixed_header">
           <thead>
               <tr>
                   <th>ID</th>
                   <th>Name</th>
                   <th>Surname</th>
                   <th>Index</th>
                   <th>Group</th>
               </tr>
           </thead>
           <tbody>
                <c:forEach var="tempStudent" items="${students}">
                    <tr>
                        <td>${tempStudent.id}</td>
                        <td>${tempStudent.firstName}</td>
                        <td>${tempStudent.lastName}</td>
                        <td>${tempStudent.studentBook}</td>
                        <td>${tempStudent.classGroup}</td>
                    </tr>
                </c:forEach>
           </tbody>
       </table>
    </div>
</body>
</html>
