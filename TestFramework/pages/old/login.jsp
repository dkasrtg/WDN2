<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<p>
    <%
    String status = (String) request.getAttribute("status");
    out.print(status);
    %>
</p>
<form action="/TestFramework/treat_login" method="get">
    <p>Name:<input type="text" name="name"></p>
    <p>Password:<input type="text" name="password" ></p>
    <button type="submit">OK</button>
</form>
</body>
</html>