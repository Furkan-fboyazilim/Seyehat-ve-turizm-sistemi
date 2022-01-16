/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author P1999
 */
public class BasketCookie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BasketCookie</title>");
            out.println("</head>");
            out.println("<body>");

            String name = request.getParameter("name");
            String triptype = request.getParameter("triptype");
            String day = request.getParameter("day");
            String price = request.getParameter("price");
            String date = request.getParameter("date");
//            String description = request.getParameter("description");
            String kisi = request.getParameter("kisi");

            Cookie nameCookie = new Cookie("Name", name);
            Cookie triptypeCookie = new Cookie("TripType", triptype);
            Cookie dayCookie = new Cookie("Day", day);
            Cookie emailCookie = new Cookie("Price", price);
            Cookie dateCookie = new Cookie("Date", date);
            Cookie descriptionCookie = new Cookie("Description", "gezihakkında");
            Cookie kisiCookie = new Cookie("Kisi", kisi);

//         userCookie.setMaxAge(5);
            response.addCookie(nameCookie);
            response.addCookie(triptypeCookie);
            response.addCookie(dayCookie);
            response.addCookie(emailCookie);
            response.addCookie(dateCookie);
            response.addCookie(kisiCookie);
            response.addCookie(descriptionCookie);

            if (name != null) {
                out.println("KULLANICI BULUNAMADI LÜTFEN TEKRAR GİRİŞ YAPINIZ");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('SEPETE EKLENDİ GİRİŞ YAPINIZ');");
                out.println("location='welcome.jsp';");
                out.println("</script>");
                out.println("<button><a href='index.jsp'>TEKRAR GİRİŞ YAPINIZ</a></button>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
