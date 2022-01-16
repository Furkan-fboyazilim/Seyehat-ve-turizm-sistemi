<%-- 
    Document   : index
    Created on : 12.Ara.2021, 15:30:40
    Author     : P1999
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String userMail = "", userPassword = "";
    Cookie[] cookies = request.getCookies();
    if (cookies.length > 0) {

        for (int i = 0; i < cookies.length; i++) {
            Cookie c = cookies[i];
            if (c.getName().equals("email")) {
                userMail = c.getValue();

            }
            if (c.getName().equals("password")) {
                userPassword = c.getValue();

            }
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Sayfası</title>
    <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="styles/cssstyle.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div class="container">
        <div class="box">
            <!--            <img class="avatar" src="img/user-avatar.png">-->
            <h2> GİRİŞ EKRANI</h2>
            <hr>
            <form action="LoginServlet" method="post">
                <p>EMAİL</p>
                <input type="text" placeholder="EMAİL" name="email"  required value="<%= userMail%>">
                    <p>ŞİFRE</p>
                    <input type="password" placeholder="ŞİFRE" name="password" required value="<%= userPassword%>">
                        <input type="checkBox"  name="remember">
                            <label>Beni Hatırla</label>
                            <button type="submit" class="registerbtn">GİRİŞ YAP</button>
                            <p>Hesabınız yoksa KAYIT OL butonuna basınız !!</p>
                            <button class="btnregister"><a href="registerPage.jsp">KAYIT OL !</a></button>
                            <button class="btnregister"><a href="welcome.jsp">ANA SAYFA</a></button>

                            </form>
                            </div>
                            </div>
                            </body>
                            </html>

