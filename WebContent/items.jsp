<%@page import="java.util.*, com.shop.domain.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="Style.css" rel="stylesheet" type="text/css">

</head>
<body>
<header>
Shop
</header>
<section>
<%
String cartAddMessage=(String)request.getAttribute("cartAddMessage");
if(cartAddMessage!=null){
%>

<span style="color: green"><%=cartAddMessage %></span>
<%
}
%>

<form name="itemForm"  method="post">

<article><p>
<table>
<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Unit Price</td>
	<td>Quantity</td>
</tr>
</table>

<%
Collection<Item> items = (Collection<Item>)request.getAttribute("items");



for(Item item:items){
%>
<tr>
	<td><input type="checkbox" name="selectedItems" value="<%=item.getId()%>"/></td>
	<td><%=item.getName()%></td>
	<td><%=item.getPrice()%></td>
	<td><input type="text" name="qty<%=item.getId()%>"/></td>
</tr>
<br>

<%
}
%>

</table>

<input type="submit" name="action" value="Add to cart"/>
<input type="submit" name="action" value="Checkout"/>
</p></article>

<input type="hidden" name="page" value="items"/>

<nav><div align=middle>
<input type="submit" name="action" value="Logout">
<input type="submit" name="action" value="help"></div>
</nav>
</form>



</section>
<footer>
Swati Savaji
</footer>
</body>
</html>