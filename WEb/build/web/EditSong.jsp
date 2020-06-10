<%-- 
    Document   : Edit
    Created on : May 27, 2020, 5:53:22 PM
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="style.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Song</h1>
       <c:if test="${empty sessionScope['teaser']}">
            <jsp:forward page="Login.jsp"/>
        </c:if>
        <jsp:useBean id="mrBean" scope="page" class="model.Dataprosess"/>
         <c:set var="s" value="${requestScope['sDetail']}"/>
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
         <form style="text-align: center" method="post" action="songcontroller?ac=update">
            Song ID:    <input readonly="true" type="text" name="txtID" value="${s.id}"  size="20"/><br/>
            Song's Name : <input type="text" value="${s.name}" name="txtName" size="30"/><br/>
            Price:      <input type="text" name="txtPrice" value="${s.price}"  size="20"/><br/>
            Sample URL: <input type="text" name="txtSample" value="${s.sampleURL}"  size="20"/><br/>
            Full URL:   <input type="text" name="txtFull" value="${s.fulURL}" size="20"/><br/>  
            Category:<input type="text" name="txtC" value="${s.idC}" size="20"/><br/>  
            Singer:  <input type="text" name="txtSg" value="${s.idSg}" size="20"/><br/>                                                                                                                                                                              
            <input type="submit"value="Save"/>
        </form>
    </body>
</html>