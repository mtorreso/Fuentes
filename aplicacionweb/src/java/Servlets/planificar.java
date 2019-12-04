/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.DepartamentoService;
import Modelo.ReservasService;
import Modelo.SendMail;
import Modelo.TransporteService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class planificar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    TransporteService ts = new TransporteService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            if (request.getParameter("conductor") != null && !request.getParameter("conductor").isEmpty()
                    && request.getParameter("auto") != null && !request.getParameter("auto").isEmpty()
                    && request.getParameter("patente") != null && !request.getParameter("patente").isEmpty()) {

                /*Validando que todos los campos no están vacíos, invocamos el método para ingresar
                 una nueva reserva con la función agregarReserva()  
                 */
                request.setAttribute("msg",
                        ts.nuevaplanificacion(request.getParameter("id_solicitud"),
                                request.getParameter("conductor"),
                                request.getParameter("auto"),
                                request.getParameter("patente")
                        )
                );
                ts.actualizarestadosolicitud(Integer.parseInt(request.getParameter("id_solicitud")),
                        request.getParameter("estado"));
                
                
                String m = request.getParameter("correo");
                String sub = "Solicitud de Transporte ha sido aceptada";
                String messg = "Estimado(a) Cliente se informa que su solicitud de transporte ha sido aceptada correctamente. para más información revisar su cuenta en http://localhost:8080/aplicacionweb/index.jsp"
                        + "                                                                                           "

                        + "                                                                                          "
                        + "                                                                                          "
                        + "Muchas gracias!";

                SendMail.send(m, sub, messg);

                if (request.getAttribute("msg").toString().contains("correctamente")) {
                    request.getRequestDispatcher("solicitudestransporte.jsp").forward(request, response);

                } else {
                    //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                    request.setAttribute("error", request.getAttribute("msg"));
                    request.getRequestDispatcher("solicitudestransporte.jsp").forward(request, response);
                }
            } else {
                //Si hay campos en blanco, la página se vuelve a cargar
                request.setAttribute("error", "Debe llenar todos los campos");
                request.getRequestDispatcher("solicitudestransporte.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Error :" + ex.toString());
            request.getRequestDispatcher("solicitudestransporte.jsp").forward(request, response);
        } finally {
            out.close();
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
    }
}
