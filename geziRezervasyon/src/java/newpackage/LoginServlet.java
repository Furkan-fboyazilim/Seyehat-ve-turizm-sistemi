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
import javax.servlet.http.HttpSession;

/**
 *
 * @author P1999
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");

            //feth data from login form
            String logemail = request.getParameter("email");
            String logpass = request.getParameter("password");
            String logid = request.getParameter("id");
            String logida = request.getParameter("remember");
            UserDatabase db = new UserDatabase(ConnectionDataBase.getConnection());
            User user = db.logUser(logemail, logpass);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("logUser", user);
                session.setAttribute("Value", user);

                if (request.getParameter("remember") != null) {
                    Cookie userCookie = new Cookie("user", user.getName());
                    Cookie passwordCookie = new Cookie("password", user.getPassword());
                    Cookie idCookie = new Cookie("id", String.valueOf(user.getId()));
                    Cookie emailCookie = new Cookie("email", user.getEmail());

//         userCookie.setMaxAge(5);
                    response.addCookie(userCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(emailCookie);
                    response.addCookie(idCookie);
                }
                if ("furkan@mail.com".equals(user.getEmail())) {
                    response.sendRedirect("admin.jsp");
                } else {
                    Cookie[] cookies2 = request.getCookies();
                    String Name = "", Day = "", Date = "", Description = "", Price = "", TripType = "", Kisi = "";
                    if (cookies2.length > 6) {
                        for (Cookie c : cookies2) {
                            if (c.getName().equals("Name")) {
                                Name = c.getValue();
                            }
                            if (c.getName().equals("Day")) {
                                Day = c.getValue();
                            }
                            if (c.getName().equals("Date")) {
                                Date = c.getValue();
                            }
                            if (c.getName().equals("Description")) {
                                Description = c.getValue();
                            }
                            if (c.getName().equals("Price")) {
                                Price = c.getValue();
                            }
                            if (c.getName().equals("TripType")) {
                                TripType = c.getValue();
                            }
                            if (c.getName().equals("Kisi")) {
                                Kisi = c.getValue();
                            }
                        }
                        String name = Name;
                        String triptype = TripType;
                        String day = Day;
                        String price = Price;
                        String date = Date;
                        String description = Description;
                        String girenid = String.valueOf(user.getId());
                        String kisi = Kisi;
//make trip object
                        Trip tripModel1 = new Trip(name, triptype, day, price, date, description, girenid, kisi);

//create a database model
                        TripDatabase regTrip = new TripDatabase(ConnectionDataBase.getConnection());
                        if (regTrip.saveBasket(tripModel1)) {
                            for (Cookie c : cookies2) {
                                if (c.getName().equals("Name")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }
                                if (c.getName().equals("Day")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }
                                if (c.getName().equals("Date")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }
                                if (c.getName().equals("Description")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }
                                if (c.getName().equals("Price")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }
                                if (c.getName().equals("TripType")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }
                                if (c.getName().equals("Kisi")) {
                                    c.setMaxAge(0);
                                    response.addCookie(c);
                                }

                            }
                            response.sendRedirect("kullaniciPage.jsp");
                        }
                    } else {
                        response.sendRedirect("kullaniciPage.jsp");
                    }
//                   
                }

            } else {
                out.println("KULLANICI BULUNAMADI LÜTFEN TEKRAR GİRİŞ YAPINIZ");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('BÖYLE BİR KULLANICI MEVCUT DEĞİL');");
                out.println("location='index.jsp';");
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
