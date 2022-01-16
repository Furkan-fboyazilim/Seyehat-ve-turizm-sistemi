<%-- 
    Document   : edittrip
    Created on : 16.Ara.2021, 19:30:49
    Author     : P1999
--%>

<%@page import="newpackage.Trip"%>
<%@page import="newpackage.TripDatabase"%>
<%@page import="newpackage.ConnectionDataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    TripDatabase bkd = new TripDatabase(ConnectionDataBase.getConnection());
    Trip bk = bkd.getSingleTrip(id);
    request.setAttribute("edit_trip", bk);
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
    <link href="styles/editcss.css" rel="stylesheet" type="text/css"/>   

    <title>Edit Book Data</title>
</head>
<body>
<div class="baslik">
    <button  id="btnexit"><a href="admin.jsp"><<< GERİ DÖN</a></button>
    <h1>GEZİ DÜZENLEME EKRANI</h1>       
</div>

<div class="editmain">
    <div class="editdiv">
        <form action="EditTrip">

            <label for="id"><b>GEZİ ID</b></label>
            <input type="text"  name="id" id="id" value="${edit_trip.id }" required readonly="readonly"></input><br>

            <label for="name"><b>GEZİ ADI</b></label>
            <input type="text" placeholder="GEZİ ADI GİRİN" name="name" id="name" value="${edit_trip.name }" required></input><br>

            <label for="triptype"><b>GEZİ TÜRÜ</b></label>
            <input type="text" placeholder="GEZİ TÜRÜ GİRİN" name="triptype" id="triptype" value="${edit_trip.triptype }" required><br>

                <label for="day"><b>KAÇ GÜN</b></label>
                <input type="text" placeholder="KAÇ GÜN" name="day" id="day" value="${edit_trip.day }" required><br>

                    <label for="price"><b>FİYAT</b></label>
                    <input type="text" placeholder="FİYAT GİRİN" name="price" id="price" value="${edit_trip.price }" ><br>

                        <label for="date"><b>TARİH</b></label>
                        <input type="date"  name="date" id="date" value="${edit_trip.date }" required><br>

                            <label for="description"><b>AÇIKLAMA</b></label>
                            <input type="text" id="description" name="description" value="${edit_trip.description }" cols="50"><br>
                                <button type="submit" class="btnedits">DÜZENLE</button>

                                <button class="btnedits"><a href="DeleteTrip?id=${edit_trip.id}"> GEZİYİ SİL</a></button>
                                </form>  
                                </div>
                                </div>
                                </body>
                                </html>

