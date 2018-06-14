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
    <jsp:param name="title" value="Punten" />
</jsp:include>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="punten" />
</jsp:include>
<main>
    <table>
        <tr>
            <th>Name</th>
            <th>vak</th>
            <th>punten</th>
        </tr>
        <tbody id="punten-table">

        </tbody>
    </table>

    <div id="add_punten_form">
        <p>
            <label for="naam-input">Name Student </label>
            <input type="text" id="naam-input" name="email-input">
        </p>
        <p>
            <label for="vak-input">Name cours </label>
            <input type="text" id="vak-input" name="vak-input">
        </p>
        <p>
            <label for="punt-input">points</label>
            <input type="number" id="punt-input" name="punt-input">
        </p>
        <p>
            <input type="submit" onclick="addNewPoints();" id="status-button" value="Add Friend">
        </p>
    </div>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="title" value="Home" />
</jsp:include>
</body>
</html>
