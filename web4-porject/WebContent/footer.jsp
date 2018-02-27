<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer>
	<c:if test="${user != null}">
		<form method="post" action="Controller?action=LogOut">
			<p>
				<input type="submit" id="logoutbutton" value="Log Out">
			</p>
		</form>
	</c:if>

	<span class="right"> &copy; Webontwikkeling 3, UC
		Leuven-Limburg 
	</span>		
</footer>
