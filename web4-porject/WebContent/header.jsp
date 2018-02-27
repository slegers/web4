<header role="banner">
<h1><span>Chatroom</span></h1>
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
    <c:when test="${user!=null}">
        <p id="status-block">${user.getFirstName()}: <div id="status">test</div>
        </p>
    </c:when>
    <c:otherwise>

    </c:otherwise>
</header>