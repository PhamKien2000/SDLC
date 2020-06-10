<%-- 
    Document   : AddSong
    Created on : May 27, 2020, 5:52:57 PM
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Song</h1>
        <jsp:useBean id="mrBean" scope="page" class="model.Dataprosess"/>
        <form method="post" action="songcontroller?ac=add">
                        <div  ><img src="images.jpg" width="100%" height="150px" alt=""> </div>
            <h2 style=" text-align: center; color: #ffffff;padding:3px 3px;" >Welcome to My Tune Source!</h2>
            <a  href='Login.jsp' >Login</a>  <a  href='registration.php' >Register</a>
            <div id="menu">
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="#">View</a>
                        <ul class="sub-menu">
                            <li><a href="ViewSong1.jsp">View Song</a></li>
                            <li><a href="ViewSinger.jsp">View Singer</a></a></li>
                            <li><a href="ViewAccount.jsp">View Account</a></li>
                            <li><a href="ViewCategory.jsp">View Category</a></li>

                        </ul>
                    </li>
                    <li><a href="#">Add</a>
                        <ul class="sub-menu">
                            <li><a href="AddSong.jsp">Add Song</a></li>
                            <li><a href="AddSinger.jsp">Add Singer</a></a></li>
                            <li><a href="AddAccount.jsp">Add Account</a></li>
                            <li><a href="AddCategory.jsp">Add Category</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Detail</a></li>
                    <button type="submit"><i class="fa fa-search"></i>Seach</button>
                    <input type="text" placeholder="Search.." name="search">
                    
           
                </ul>
                </ul>
            </div >
            SongID: <input type="text" name="txtID" size="20"/><br/>
            SongName: <input type="text" name="txtName" size="20"/><br/>
            Price:  <input type="text" name="txtPrice" size="20"/><br/>
            SampleSong:  <input type="text" name="txtSample" size="20"/><br/>
            FullSong  <input type="text" name="txtFull" size="20"/><br/>  
            Category:  <input type="text" name="txtC" size="20"/><br/>  
            Singer:  <input type="text" name="txtSg" size="20"/><br/>  
            <input type="submit"value="Add"/>
        </form>
    </body>
</html>
