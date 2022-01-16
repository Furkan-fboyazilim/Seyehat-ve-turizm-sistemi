
<%-- 
    Document   : turlarPage
    Created on : 15.Ara.2021, 23:28:09
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
    String girenid = String.valueOf(user.getId());
    TripDatabase data = new TripDatabase(ConnectionDataBase.getConnection());
    List<Trip> tripp = data.ListTripKisi(girenid);
    request.setAttribute("geziler", tripp);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="styles/kullanicicss.css" rel="stylesheet" type="text/css"/> 
    <title>Turlar Sayfası</title>
</head>
<body>
    <header>
        <button id="btnexit"><a href="kullaniciPage.jsp"> <<< GERİ DÖN</a></button>   
        <h1>REZERVASYON YAPILAN TURLAR</h1>
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
                <p>KİŞİ: ${deneme.kisi}</p> 
                <button class="btnEkle"><a href="rezerveTripEdit.jsp?id=${deneme.id}">TURU DÜZENLE</a></button>
                <hr>    
                <p>${deneme.description}</p>
                <hr>            

            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
