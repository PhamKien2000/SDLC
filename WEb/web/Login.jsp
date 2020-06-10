<%-- 
    Document   : Login
    Created on : May 27, 2020, 5:53:10 PM
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" />
        <title >Login</title>
    </head>
    <body style=" text-align: center"  >
        <h1 >Login form</h1>
        <FORM method="POST" action="Controller">
            Username: <input type="text" name="txtUsername" size="30"/><br/>
            Password: <input type="password" name="txtPass" size="30"/><br/>
            <input type="submit" value="login"/>
            <input type="reset" value="cancel"/><br/>
            <button <a href="AddAccount.jsp">Register</a> </button>
                    
        </FORM>
    </body>
</html>
