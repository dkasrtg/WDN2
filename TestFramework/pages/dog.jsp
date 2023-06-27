<%@ page isErrorPage="true"%>
<%@ page import="model.Dog"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/TestFramework/assets/css/dog.css">
    <title>Title</title>
</head>
<body>
<%
String[] dogs = (String[]) request.getAttribute("dogs");
for(int i=0;i<dogs.length;i++){
    %><p><%out.print(dogs[i]);%></p><%
}
%>
<p><%
Dog alik = (Dog) request.getAttribute("alik");
out.print(alik.getName());
%></p>
</body>
</html>