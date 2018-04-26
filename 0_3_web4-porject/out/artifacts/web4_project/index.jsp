<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<jsp:include page="head.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<body>
	<jsp:include page="header.jsp">
		<jsp:param name="title" value="Home" />
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
</c:if> <c:choose>
	<c:when test="${user!=null}">
		<p>Welcome ${user.getFirstName()}!</p>
	</c:when>
	<c:otherwise>
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
	</c:otherwise>
</c:choose>
	<c:forEach var="b" items="${blogs}">
		<div class="blog-${b.id}">
			<div class="topic-subject">
				<h2>${b.title}</h2>
			</div>
			<div  id="topic-comments"></div>
			<p>
				<label for="naam">name </label>
				<input type="text" id="naam" name="naam" value="">
			</p>
			<p>
				<label for="rating">Your Rating (1-10)</label>
				<input type="number" id="rating" name="rating" value="" min="1" max="10">
			</p>
			<p>
				<label for="Comment">Comment</label>
				<input type="text" id="comment" name="comment" value="" min="1" max="10">
			</p>
			<p>
				<button onclick="openSocket(${b.id});" id="comment-submit"> Comment </button>
			</p>
		</div>
	</c:forEach>
	</main>
	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
</body>
</html>