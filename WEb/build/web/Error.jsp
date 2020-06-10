<%-- 
    Document   : Error
    Created on : May 27, 2020, 5:53:48 PM
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login form</h1>
        <FORM method="POST" action="Controller">
            Username: <input type="text" name="txtUsername" size="30"/><br/>
            Password: <input type="password" name="txtPass" size="30"/><br/>
            <input type="submit" value="login"/>
            <input type="reset" value="cancel"/>
        </FORM>
    </body>
</html>
