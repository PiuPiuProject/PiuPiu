<%-- 
    Document   : Profile
    Created on : 12-may-2017, 18:02:53
    Author     : DAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("user");
            if (user != null) {
        %>
        <h1>Hola <%=user%></h1>
        <h3>Crear Piu</h3>
        <form action="PiuForm.jsp">
            <input type="submit" value="Crear">
        </form>
        <% } else {
        %>
        <h1>Error, usuario no validado.</h1>
        <%
    }%>
        
        
    </body>
</html>
