<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<h1 id="title">Chatroom</h1>
    <c:if test="${user != null}">
        <div id="status-block">${user.getFirstName()}: <div id="status-text"></div></div>
        <p>
            <label for="status-input">Your status </label>
            <input type="text" id="status-input" name="status-input">
        </p>
        <p>
            <input type="submit" onclick="setNewStatus();" id="status-button" value="Update Status">
        </p>
    </c:if>
<nav>
<ul>
    <c:choose>
        <c:when test="${param.title=='Home' && user == null}">
            <li  id="actual"><a href="Controller">Home</a></li>
            <li><a href="Controller?action=RegisterPage">Register</a></li>

        </c:when>
        <c:otherwise>
            <li><a href="Controller">Home</a></li>
            <li><a href="Controller?action=FriendsOverview">Friends</a></li>

        </c:otherwise>
    </c:choose>
</ul>
</nav>
    <h2>
        ${param.title}
    </h2>
</header>