<%@ page import="com.example.lab_15_last_lat.Products" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>lab15</title>
</head>
<body>
<h1 align="center"><big><big>Billboard</big></big></h1>

<%
    String link;
    HttpSession session1 = request.getSession();
    if(session1.getAttribute("login") != null) {
        link = "<h2 align=\"center\"> <a href=\"LogoutServlet\"><big>Logout</big></a></h2>\n" +
                "<h2 align=\"center\"> <a href=\"AddProduct.jsp\">AddNote</a></h2>"
        ;
    }
    else{
        link = "<h1 align=\"center\"> <a href=\"loginPage.html\">Login</a></h1>\n";
    }
%>

<%=link%>

<%

    Products products = new Products();

    String data = products.getBooksForPrint();


%>

<%= data%>
</body>
</html>