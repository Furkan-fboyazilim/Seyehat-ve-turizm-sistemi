<%-- 
  Document   : admin
  Created on : 14.Ara.2021, 15:55:56
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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="styles/admincss.css" rel="stylesheet" type="text/css"/>           
    <title>Admin Sayfası</title> 
</head>
<body>
    <header>
        <h1> Hoşgeldin  <%= user.getName()%></h1>
        <h1>ADMİN PANELİ</h1>
        <button id="btnexit"><a href="LogOutServlet"> <<< ÇIKIŞ YAP</a></button>
    </header>

<div class="main"> 
    <div class="girdiler">
        <form action="AdminServlet">
            <label for="name"><b>GEZİ ADI</b></label>
            <input type="text" placeholder="GEZİ ADI GİRİN" name="name" id="name" required></input><br>

            <label for="triptype"><b>GEZİ TÜRÜ</b></label>
            <input type="text" placeholder="GEZİ TÜRÜ GİRİN" name="triptype" id="triptype" required><br>

            <label for="day"><b>KAÇ GÜN</b></label>
            <input type="text" placeholder="KAÇ GÜN" name="day" id="day"  required><br>

            <label for="price"><b>FİYAT</b></label>
            <input type="text" placeholder="FİYAT GİRİN" name="price" id="price" required><br>

            <label for="date"><b>TARİH</b></label>
            <input type="date"  name="date" id="date" required><br>

            <label for="description"><b>AÇIKLAMA</b></label>
            <textarea id="description" name="description" rows="10" cols="50"></textarea>
            <button type="submit" class="btnEkle" >EKLE</button> 
        </form>  
    </div>
    <div class="geziler">

        <c:forEach var="deneme" items="${geziler}">
            <div class="geziCart">
                <img src="img/gezip.jfif" alt="yükleniyor..."></img>
                <p>${deneme.name} , ${deneme.triptype}</p>       
                <p>TARİH: ${deneme.date}  ,  ${deneme.day} GÜN</p>
                <p>FİYAT : ${deneme.price} TL</p> 
                <button class="btnSec"><a href="edittrip.jsp?id=${deneme.id}"> GEZİYİ SEÇ</a></button>
                 <hr>    
                <p>${deneme.description}</p>
                <hr>
            </div>
        </c:forEach>
    </div>
</div>
                            </body>
                            </html>
