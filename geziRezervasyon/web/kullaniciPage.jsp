<%-- 
    Document   : kullaniciPage
    Created on : 15.Ara.2021, 13:52:33
    Author     : P1999
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page import="java.util.List"%>
<%@page import="newpackage.Trip"%>
<%@page import="newpackage.ConnectionDataBase"%>
<%@page import="newpackage.TripDatabase"%>
<%@page import="newpackage.User"%>
<% User user = (User) session.getAttribute("logUser");
    if (user == null) {
        response.sendRedirect("index.jsp");
    }
%>



<%
    TripDatabase data = new TripDatabase(ConnectionDataBase.getConnection());
    List<Trip> tripp = data.selectTrip();
    request.setAttribute("geziler", tripp);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="styles/kullanicicss.css" rel="stylesheet" type="text/css"/> 
    <title>JSP Page</title>
</head>
<body>

    <header>
        <div class="sepet">
            <button id="btnexit"><i class="fas fa-heart"></i><a href="LogOutServlet"> <<< ÇIKIŞ YAP</a></button><br>
            <button id="btntur"><i class="fas fa-heart"></i><a href="turlarPage.jsp"> TURLARIM >>> </a></button><br>
            <button id="btntur"><i class="fas fa-heart"></i><a href="userEdit.jsp"> HESABIM >>> </a></button>
        </div>
        <h1>GEZİ REZERVASYON PANELİ</h1>      
        <h1> Hoşgeldin  <%= user.getName()%></h1>
    </header>

<div class="main">
    <div class="geziler">
        <c:forEach var="deneme" items="${geziler}">
            <div class="geziCart">

                <img src="img/gezip.jfif" alt="yükleniyor..."></img>
                <p>${deneme.name} , ${deneme.triptype}</p>       
                <p>TARİH: ${deneme.date}  ,  ${deneme.day} GÜN</p>
                <p>FİYAT : ${deneme.price} TL</p> 
                <button class="btnEkle"><a href="baskettripedit.jsp?id=${deneme.id}"> GEZİYİ SEÇ</a></button>
                <hr>    
                <p>${deneme.description}</p>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
