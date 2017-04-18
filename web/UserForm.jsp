<%-- 
    Document   : UserForm
    Created on : 28-mar-2017, 18:33:10
    Author     : DAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>-
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Account</h1>
            <form action="CreateAccount" method ="POST">
            
            Username: <input type="text" name="username">
            Surname: <input type="text" name="surname">
            Name: <input type="text" name="name">
            Email: <input type="email" name="email">
            Password: <input type="password" name="password">
            
            <input type="submit" value="Create" name="usuario">
            </form>
            <form action="index.html"><input type="submit" value="Cancelar"></form>
    </body>
</html>






           