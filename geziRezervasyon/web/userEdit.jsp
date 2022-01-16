<%-- 
    Document   : userEdit
    Created on : 15.Oca.2022, 15:12:36
    Author     : P1999
--%>


<%@page import="newpackage.UserDatabase"%>
<%@page import="newpackage.ConnectionDataBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="newpackage.User"%>

<% User user = (User) session.getAttribute("logUser");
    if (user == null) {
        response.sendRedirect("index.jsp");
    }
%>
<%
    int id = user.getId();
    UserDatabase bkd = new UserDatabase(ConnectionDataBase.getConnection());
    User bk = bkd.getSingleUser(id);
    request.setAttribute("edituser", bk);
%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
    <link href="styles/editcss.css" rel="stylesheet" type="text/css"/>   

    <title>Edit User</title>
</head>
<body>
<div class="baslik">
    <button  id="btnexit"><a href="kullaniciPage.jsp"><<< GERİ DÖN</a></button>
    <h1>KULLANICI DÜZENLEME EKRANI</h1>       
</div>

<div class="editmain">
    <div class="editdiv">
        <form action="EditUserServlet">

            <label for="id"><b>USER ID :</b></label>
            <input type="text"  name="id" id="id" value="${edituser.id}" required readonly="readonly" ></input><br>

            <label for="ad"><b>AD : </b></label>
            <input type="text"  name="name" id="name" value="${edituser.name}" required ></input><br>

            <label for="email"><b>EMAİL :</b></label>
            <input type="text"  name="email" id="email" value="${edituser.email}" required ></input><br>

            <label for="password"><b>ŞİFRE :</b></label>
            <input type="text"  name="password" id="password" value="${edituser.password}" required ></input><br>

            <button type="submit" class="btnedits">DÜZENLE</button>

            <button class="btnedits"><a href="DeleteUserServlet?id=<%= user.getId()%>"> HESABI SİL</a></button>
        </form>
    </div>
</div>

</body>
</html>
