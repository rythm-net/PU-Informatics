<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
final String[] CUSTOMERS = { "Ivan Petrov", "Maria Ivanova", "Dragan Draganov" };
%>
<!DOCTYPE html>
<html>
<body>

	Customers:
	<br>
	<br>
	<table>
		<%
		for (int i = 0; i < CUSTOMERS.length; i++) {
			out.println("<tr><td>");
		%>
		<%=CUSTOMERS[i]%>
		</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
