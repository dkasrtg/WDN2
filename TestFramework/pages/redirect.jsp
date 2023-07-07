<%
String link = (String) request.getAttribute("link");
response.sendRedirect(link);
%>