<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="MyStyle.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<header>
Shop
</header>
<%
String loginError=(String)request.getAttribute("loginError");
if(loginError!=null){
%>

<span style="color: red"><%=loginError %></span>

<%
}
%>
<section>
<article>
<nav>
<form name="loginForm" action="ShoppingController" method="post">
<h2> Login </h2>
Username: <input type="text" name="username"/><br><br>
Password: <input type="password" name="password"/><br><br>

<input type="submit" name="action" value="Login" />
<input type="reset" value="Reset"/>
<input type="hidden" name="page" value="login"/>



</form></nav>
</article>
</section>
<footer>
Swati Savaji
</footer>

</body>
</html>