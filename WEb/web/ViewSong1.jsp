<%-- 
    Document   : ViewSong1
    Created on : May 27, 2020, 5:52:32 PM
    Author     : kienv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" />
        <title>JSP Page</title>
    </head>
    <body >
        <c:if test="${empty sessionScope['teaser']}">
            <jsp:forward page="Login.jsp"/>
        </c:if>
        <c:choose>
            <c:when test="${empty requestScope['list']}">
                <jsp:forward page="songcontroller?ac=view" />
            </c:when>
            <c:otherwise>
                <div id="menu">  
                    <div  ><img src="images.jpg" width="100%" height="150px" alt=""> </div>
                   <h1 style="text-align: center;padding-top: 10px" >Management Admin</h1><h1 style="text-align: center">Song List!</h1>
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
                <div id="menu">  
                    <table border="1" width="100%">
                        <tr  style="color: lightslategray; background: blanchedalmond; border-style: solid">
                            <th>ID</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Sample</th>
                            <th>Full</th>
                            <th>IDC</th>
                            <th>IDS</th>
                            <th>Delete</th>
                            <th>Edit</th>
                        </tr>
                        <jsp:useBean id="mrBean" scope="page" class="model.Dataprosess"/>
                        <c:forEach var="s" items="${mrBean.song}">
                            <tr>
                                <td >${s.id}</td>
                                <td >${s.name}</td>
                                <td >${s.price}</td>                             
                                <td style="text-align: center" ><li><a href="${s.sampleURL}">Listen</a></li></td>
                            <td style="text-align: center" ><li><a href="${s.fulURL}">Listen</a></li></td>
                            <td >${s.idC}</td>
                            <td >${s.idSg}</td>
                            <td><a href="songcontroller?ac=del&id=${s.id}">Delete</a></td>
                            <td><a href="songcontroller?ac=edit&id=${s.id}">Edit</a></td>

                            </tr>  
                        </c:forEach>
                    </table>
                    

                    <p style="color: darkred">Hotline:033888100</p>
                    <p style="color: darkred">Email:Vankien3172000@gmail.com</p>
                    <p style="color: darkred">Company: Tune Source Address Detech tower 2 Hà Nội</p>
                </c:otherwise>
            </c:choose></div>


</body>
</html>
