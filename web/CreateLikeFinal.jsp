<%-- 
    Document   : CreateAccountFinal
    Created on : 04-abr-2017, 17:38:06
    Author     : DAM
--%>

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
            if (status.equals(CreateAccount.STATUS_OK)) {             
                request.getRequestDispatcher("/Profile.jsp").forward(request, response);
            %>
        <% } else if (status.equals(CreateAccount.STATUS_ERROR)) { %>
        <% }             
        %>

    </body>
</html>