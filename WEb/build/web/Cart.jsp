<%-- 
    Document   : Cart
    Created on : May 27, 2020, 5:53:38 PM
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
          <div  ><img src="Cart.png" width="100%" height="150px" alt=""> </div>
        <h1 style="text-align: center">Welcome to Product</h1>
        <c:choose>
            <c:when test="${empty requestScope['list']}">
                <jsp:forward page="songcontroller?ac=detail" />
            </c:when>
            <c:otherwise>
               
                <div id="menu">
                <ul>
                    <li><a href="Home.jsp">Home</a></li>
                    <li><a href="#">View</a>
                        <ul class="sub-menu">
                            <li><a href="Cart.jsp">View Song</a></li>
                            <li><a href="ViewSinger.jsp">View Singer</a></a></li>
                            <li><a href="ViewAccount.jsp">View Account</a></li>
                            <li><a href="ViewCategory.jsp">View Category</a></li>

                        </ul>
                    </li>
                   
                    <li><a href="#">Detail</a></li>
                    <button type="submit"><i class="fa fa-search"></i>Seach</button>
                    <input type="text" placeholder="Search.." name="search">
                    
           
                </ul>
                    <h1 style="text-align: center">Song List!</h1>
                <table border="1" width="100%">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Full</th>
                        <th>Category</th>
                        <th>Singer</th>
                    </tr>
                    <jsp:useBean id="mrBean" scope="page" class="model.Dataprosess"/>
                    <c:forEach var="s" items="${mrBean.song}">
                        <tr>
                            <td >${s.id}</td>
                            <td >${s.name}</td>
                            <td >${s.price}</td>
                            <td style="text-align: center" ><li><a href="${s.fulURL}">Download</a></li></td>
                            <td >${s.idC}</td>
                            <td >${s.idSg}</td>  
                        </tr>  
                    </c:forEach>
                </table>
                     <div  ><img src="music.jpg" width="100%" height="100px" alt=""> </div>
                     <p style="color: darkred">Hotline:033888100</p>
                     <p style="color: darkred">Email:Vankien3172000@gmail.com</p>
                     <p style="color: darkred">Company: Tune Source Address Detech tower 2 Hà Nội</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>

