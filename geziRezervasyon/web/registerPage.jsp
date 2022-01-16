<%-- 
    Document   : registerPage
    Created on : 12.Ara.2021, 22:47:43
    Author     : P1999
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="styles/cssstyle.css" rel="stylesheet" type="text/css"/>
    <title>Kayıt Sayfası</title>
</head>
<body>

    <form action="RegisterServlet">
        <div class="container">
            <h2>YENİ KAYIT EKRANI</h2>
            <hr>
            <label for="name"><b>KULLANICI ADI</b></label>
            <input type="text" placeholder="KULLANICI ADI GİRİNİZ" name="name" id="name" required></input>

            <label for="email"><b>MAİL</b></label>
            <input type="text" placeholder="MAİL GİRİNİZ" name="email" id="email" required>

                <label for="psw"><b>ŞİFRE</b></label>
                <input type="password" placeholder="ŞİFRE GİRİNİZ" name="password" id="password" required>

                    <label for="psw-repeat"><b>ŞİFRE TEKRAR</b></label>
                    <input type="password" placeholder="ŞİFRENİZİ TEKRAR GİRİNİZ" name="psw-repeat" id="psw-repeat" required>
                        <hr>
                        <button type="submit" class="registerbtn">KAYIT OL</button>
                        </div>
                        <div class="container signin">
                            <p>Zaten hesabınız var mı? <a href="index.jsp">GİRİŞ YAP</a>.</p>
                        </div>
                        </form>
                        </div>
                        </div>
                        </body>
                        </html>
