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
</c:choose> </main>
	<jsp:include page="footer.jsp">
		<jsp:param name="title" value="Home" />
	</jsp:include>
	<div class="topic-1">
		<div class="topic-subject">
			<h2>Is Deze opleiding een nuttig?</h2>
		</div>
		<div  class="topic-comments">

		</div>
	</div>
	<div class="topic-2">
		<div class="topic-subject">
			<h2>Kan web2 & Web3 worden samengevoegd tot 1 vak van 4 studiepunten?</h2>
		</div>
		<div  class="topic-comments">

		</div>
	</div>
	<div class="topic-3">
		<div class="topic-subject">
			<h2>Moet netwerken uitgebreider aan bod komen in deze opleiding?</h2>
		</div>
		<div  class="topic-comments">

		</div>
	</div>
	<div class="topic-4">
		<div class="topic-subject">
			<h2>Wat zijn de examenvragen van web4?</h2>
		</div>
		<div  class="topic-comments">

		</div>
	</div><div class="topic-5">
		<div class="topic-subject">
			<h2>Waren de segregatiewetten van de USA anders dan de Neurenberger wetten?</h2>
		</div>
		<div  class="topic-comments">

		</div>
	</div>
	<form method="post">
		<p>
			<label for="naam">name </label>
			<input type="text" id="naam" name="email" value="">
		</p>
		<p>
			<label for="rating">Your Rating (1-10)</label>
			<input type="number" id="rating" name="rating" value="" min="1" max="10">
		</p>
		<p>
			<label for="Comment">Comment</label>
			<input type="number" id="comment" name="rating" value="" min="1" max="10">
		</p>
		<p>
			<label for="topic">Comment</label>
			<select id="topic" name="topic">
				<option value="1">Is Deze opleiding een nuttig?</option>
				<option value="2">Kan web2 & Web3 worden samengevoegd tot 1 vak van 4 studiepunten?</option>
				<option value="3">Moet netwerken uitgebreider aan bod komen in deze opleiding?</option>
				<option value="4">Wat zijn de examenvragen van web4?</option>
				<option value="5">Waren de segregatiewetten van de USA anders dan de Neurenberger wetten?git </option>
			</select>
		</p>
		<p>
			<input type="submit" id="comment-submit" value="Add Comment">
		</p>
	</form>
</body>
</html>