<%--
  Created by IntelliJ IDEA.
  User: vovai
  Date: 22.10.2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">Add Product</h1>

<form action="AddProductServlet" method="post">
    Name:<input type="text" name="name"><br>
    Description:<input type="text" name="description"><br>
    <input type="submit" name="add">
</form>

</body>
</html>
