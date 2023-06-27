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
        String auth = (String) request.getAttribute("auth");
        out.print(auth);
    %>
</p>

</body>
</html>