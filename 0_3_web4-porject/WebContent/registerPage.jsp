<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Register" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Register" />
</jsp:include>
<main>
    <c:if test="${errors.size()> 0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
        <form method="post" action="Controller?action=Register">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="yanice@ucll.be">
            </p>
            <p>
                <label for="firstname">Your first name </label>
                <input type="text" id="firstname" name="firstname" value="yanice">
            </p>
            <p>
                <label for="lastname">Your last name </label>
                <input type="text" id="lastname" name="lastname" value="Slegers">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Register">
            </p>
        </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>