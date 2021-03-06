<%-- 
    Document   : Profile
    Created on : 12-may-2017, 18:02:53
    Author     : DAM
--%>

<%@page import="entities.User"%>
<%@page import="entities.Piu"%>
<%@page import="java.util.List"%>
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
        <h1>Your Pius</h1>
        <table>
            <tr>
                <th>Author</th>
                <th>Text</th>
                <th>Creation</th>
            </tr>
            <%
                List<Piu> pius = (List<Piu>) request.getAttribute("pius");
                for (Piu p : pius) {
            %>
            <tr>
                <td><%= p.getAuthorId()%></td> 
                <td><%= p.getText()%></td> 
                <td><%= p.getPubDate()%></td> 
                <%
                    if (pius.size() >= 1) {%>
                <td>
                    <form action="CreateComment" method="POST">
                        <input type="text" name="text">
                        <input type="hidden" name="idpiu" value="<%= p.getPiuId()%>">
                        <input type="hidden" name="user" value="<%= p.getAuthorId().getUsername()%>">
                        <input type="submit" value="Comment">
                    </form>
                </td>
                <td>
                    <form action="CreateLike">
                        <input type="hidden" name="idpiu" value="<%= p.getPiuId()%>">
                        <input type="hidden" name="user" value="<%= p.getAuthorId().getUsername()%>">
                        <input type="submit" value="Like">
                    </form>
                </td>
                <%  } %>
            </tr>
            <% }
            %>
        </table>
        <h1>Your Followers</h1>
        <table>
            <tr>
                <th>Name</th>
                <th>Action</th>
            </tr>
            <%
                List<User> followers = (List<User>) request.getAttribute("followers");
                if (followers != null) {
                    for (User u : followers) {
            %>
            <tr>
                <td><%= u.getName()%></td> 
                <td><%= u.getUsername()%></td>
            </tr>
            <% }
                
            %>
        </table>
    </table>
    <h1>People to Follow</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <%
            //List<User> tofollow = (List<User>) request.getAttribute("tofollow");
            for (User u : followers) {
        %>
        <tr>
            <td><%= u.getName()%></td> 
            <td>
                <form action="CreateFollower">
                        <input type="hidden" name="follower_id" value="<%= user %>">
                        <input type="hidden" name="followee_id" value="<%= u.getUsername()%>">
                        <input type="submit" value="like">
                </form>
            </td>
        </tr>
        <% } }
        %>
    </table>
    <% } else {
    %>
    <h1>Error, usuario no validado.</h1>
    <%
            }%>
</body>
</html>
