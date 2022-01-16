<%-- 
    Document   : rezerveTripEdit
    Created on : 14.Oca.2022, 21:45:40
    Author     : P1999
--%>

<%@page import="newpackage.Trip"%>
<%@page import="newpackage.TripDatabase"%>
<%@page import="newpackage.ConnectionDataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    TripDatabase bkd = new TripDatabase(ConnectionDataBase.getConnection());
    Trip bk = bkd.getSinglRezerveTrip(id);
    request.setAttribute("edittrip", bk);
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
    <link href="styles/editcss.css" rel="stylesheet" type="text/css"/>   

    <title>Rezerve Turlar</title>
</head>
<body>
<div class="baslik">
    <button  id="btnexit"><a href="turlarPage.jsp"><<< GERİ DÖN</a></button>
    <h1>GEZİ DÜZENLEME EKRANI</h1>       
</div>     
<div class="editmain">
    <div class="editdiv">
        <form action="EditRezerveTrip">

            <label for="id"><b>GEZİ ID</b></label>
            <input type="text"  name="id" id="id" value="${edittrip.id }" required readonly="readonly"></input><br>

            <label for="kisi"><b>KİŞİ SAYISI</b></label>
            <input type="number"  name="kisi" id="kisi" min="1" MAX="5" value="${edittrip.kisi }" required><br>

                <button type="submit" class="btnedits">DÜZENLE</button>

                <button class="btnedits"><a href="DeleteRezerveServlet?id=${edittrip.id}"> GEZİYİ SİL</a></button>
        </form>   
    </div>
</div>
</body>
</html>

