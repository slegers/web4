<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header role="banner">
<h1 id="title">Chatroom</h1>
    <c:if test="${user != null}">
        <div id="status-block">${user.getFirstName()}: <div id="status-text"> ${user.getStatus()}</div></div>
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