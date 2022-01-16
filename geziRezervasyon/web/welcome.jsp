<%-- 
    Document   : welcome
    Created on : 13.Ara.2021, 22:12:11
    Author     : P1999
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page import="java.util.List"%>
<%@page import="newpackage.Trip"%>
<%@page import="newpackage.ConnectionDataBase"%>
<%@page import="newpackage.TripDatabase"%>
<%@page import="newpackage.User"%>



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
    <title>Anasayfa</title>
</head>
<body>

    <header>
        <button id="btnexit"><i class="fas fa-heart"></i><a href="LogOutServlet"> <<< GİRİŞ EKRANI</a></button>
        <h1>GEZİ REZERVASYON PANELİ</h1>
        <div class="sepet">
            <h1> Hoşgeldin </h1><br>
        </div>
    </header>

<div class="main">
    <div class="geziler">
        <c:forEach var="deneme" items="${geziler}">
            <div class="geziCart">

                <img src="img/gezip.jfif" alt="yükleniyor..."></img>
                <p>${deneme.name} , ${deneme.triptype}</p>       
                <p>TARİH: ${deneme.date}  ,  ${deneme.day} GÜN</p>
                <p>FİYAT : ${deneme.price} TL</p> 
                <button class="btnEkle"><a href="welcomeBasket.jsp?id=${deneme.id}"> GEZİYİ SEÇ</a></button>
                <hr>    
                <p>${deneme.description}</p>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
