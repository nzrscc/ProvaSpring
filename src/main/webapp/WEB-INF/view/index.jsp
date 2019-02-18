<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
	<div>
		<div>
			<h1>Spring Boot JSP Example</h1>
			<h2>Hello ${message}</h2>

			<form action="next" method="get">
				<h1>Inerisci nome</h1>
			<br>
				<input type="text" value="name">
				<br>
				<input type="submit" value="Clicca qui!">
			<br>
			</form>

			Click on this <strong><a href="next">link</a></strong> to visit another page.
		</div>
	</div>
</body>
</html>
