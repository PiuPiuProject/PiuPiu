<%-- 
    Document   : CreateAccountFinal
    Created on : 04-abr-2017, 17:38:06
    Author     : DAM
--%>

<%@page import="servlet.LoginAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Done</title>
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("user");
            if (user != null) { %>
        <p>Login succesfull.</p> 
        <% } else { %>
        <p>Login imposible.</p>
        <% } %>
        <a href="Profile.jsp">Profile page.</a>
    </body>
</html>