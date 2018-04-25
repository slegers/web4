<%--
  Created by IntelliJ IDEA.
  User: yanice
  Date: 15/03/2018
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
    <jsp:param name="title" value="Friends overview" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Friends overview" />
</jsp:include>
<main>
    <c:if test="${errors.size()>0 }">
        <div class="danger">
            <ul>
                <c:forEach var="error" items="${errors }">
                    <li>${error }</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <c:choose>
    <c:when test="${user!=null}">
        <table>
            <tr>
                <th>Name</th>
                <th>Status</th>
                <th>Chat?</th>
            </tr>
            <tbody id="friends-table">

            </tbody>
        </table>
        <div class="add_friend_form">
        <p>
            <label for="email-input">Your friends userID </label>
            <input type="text" id="email-input" name="email-input">
        </p>
        <p>
            <input type="submit" onclick="addNewFriend();" id="status-button" value="Add Friend">
        </p>
        </div>
    </c:when>
    <c:otherwise>
        <p>Your'e aren't allowed on this page.</p>
    </c:otherwise>
</c:choose> </main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>
