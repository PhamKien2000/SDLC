<%-- 
    Document   : Home
    Created on : May 28, 2020, 5:07:38 PM
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty sessionScope['teaser']}">
            <jsp:forward page="Login.jsp"/>
        </c:if>


        <div>
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
            </div>
        </div>
        <div id="Production">	
            <ul>
                <li>
                    <a href="#" title="">
                        <img src="pop.jpg" alt="" width="450px" height="450px">
                    </a>
                </li>
                <li>
                    <a href='smartphone.php' title="">
                        <img src="rock.jpg" alt="" width="450px" height="450px">

                    </a>

                </li>
                <li>
                    <a href='laptop.php' title="">
                        <img src="disco.jpg" alt="" width="450px" height="450px">
                    </a>

                </li>
        </div>
    </body>
</html>
