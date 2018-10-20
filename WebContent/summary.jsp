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
<form name="summaryForm" action="ShoppingController" method="post">

<article>
<p align=middle>
<table>
<tr>
	<td>ID</td>
	<td>Name</td>
	<td>Price</td>
	<td>Quantity</td>
</tr>
<%
Collection<Item> items = (Collection<Item>)session.getAttribute("cart");
float sum=0;

for(Item item:items){
%>

<tr>
	<td><%=item.getId()%></td>
	<td><%=item.getName()%></td>
	<td><%=item.getPrice()*item.getQuantity()%></td>
	<td><%=item.getQuantity() %></td>
</tr>

<%
sum=sum+item.getPrice()*item.getQuantity();

}
%>

<tr>
<td> Total </td>
<td> <%=sum%> </td>
</tr>


</table>

<input type="submit" name="action" value="Back to cart"/>
<input type="submit" name="action" value="Checkout"/>
</p>
</article>

<input type="hidden" name="page" value="summary"/>
<nav>
</nav>
</form>

<footer>
Swati Savaji
</footer>

</body>
</html>
