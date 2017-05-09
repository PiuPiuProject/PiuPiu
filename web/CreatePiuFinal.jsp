<%-- 
    Document   : CreatePiu
Final
    Created on : 04-abr-2017, 17:38:06
    Author     : DAM
--%>

<%@page import="servlet.CreatePiu"%>
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
            if (status.equals(CreatePiu.STATUS_OK)) { %>
        <p>User registered.</p> 
        <% } else if (status.equals(CreatePiu.STATUS_ERROR)) { %>
        <p>User already exists.</p>
        <% } %>
        <a href="index.html">Main menu</a>
    </body>
</html>