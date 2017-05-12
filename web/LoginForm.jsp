<%-- 
    Document   : UserForm
    Created on : 28-mar-2017, 18:33:10
    Author     : DAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Account</h1>
            <form action="LoginAccount" method ="POST">
            
            Username: <input type="text" name="username">
            Password: <input type="password" name="password">
            
            <input type="submit" value="Login" name="Entry">
            </form>
            <form action="index.html"><input type="submit" value="Cancelar"></form>
    </body>
</html>






           