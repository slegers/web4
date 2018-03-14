<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<h1 id="title">Chatroom</h1>
    <c:if test="${user != null}">
        <div id="status-block">${user.getFirstName()}: <div id="status-text"></div></div>
        <form method="post" action="Controller?action=LogIn">
            <p>
                <label for="email">Your email </label>
                <input type="text" id="email" name="email" value="jan@ucll.be">
            </p>
            <p>
                <label for="password">Your password</label>
                <input type="password" id="password" name="password" value="t">
            </p>
            <p>
                <input type="submit" id="loginbutton" value="Log in">
            </p>
        </form>
    </c:if>
<nav>
<ul>
    <c:choose>
        <c:when test="${param.title=='Home'}">
            <li  id="actual"><a href="Controller">Home</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="Controller">Home</a></li>
        </c:otherwise>
    </c:choose>
</ul>
</nav>
    <h2>
        ${param.title}
    </h2>
</header>