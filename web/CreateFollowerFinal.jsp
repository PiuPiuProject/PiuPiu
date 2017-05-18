<%-- 
    Document   : CreateAccountFinal
    Created on : 04-abr-2017, 17:38:06
    Author     : DAM
--%>

<%@page import="servlet.CreateLike"%>
<%@page import="servlet.CreateAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Done</title>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
            if (status.equals(CreateLike.STATUS_OK)) { %>
        <p>Follower ok</p> 
        <% } else if (status.equals(CreateLike.STATUS_ERROR)) { %>
        <p>Follower error</p>
        <% } %>
        <a href="cargarlista">User Profile</a>

    </body>
</html>