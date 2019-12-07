/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.CuentasService;
import Modelo.SendMail;
import Modelo.ServicioService;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author torre
 */
public class contratarservicio extends HttpServlet {

    String index = "servdeptos.jsp";
    String acceso = "";
    ServicioService serv = new ServicioService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion.equals("contratar")) {

            try {
                if (request.getParameter("id_srv") != null) {

                    request.setAttribute("msg",
                            serv.contratarservicio(request.getParameter("fecha_contratacion"),
                                    request.getParameter("id_srv"),
                                    request.getParameter("id_reserva")
                            )
                    );
                    String m = request.getParameter("correo");
                    String sub = "Turismo Real >> Servicio Contratado";

                    String messg = "Estimado , \n"
                            + "\n"
                            + "Se informa que se ha contratado correctamente el servicio que se detalla a continuación . \n"
                            + "Fecha Contratación  :"+request.getParameter("fecha_contratacion")+"\n"
                            + "Nombre Servicio     :"+request.getParameter("nombre")+"\n"
                            + "Precio              :"+request.getParameter("precio")+"\n"
                            + "-------------------------------------------------------------------------------------------------------------------\n"
                            + "\n"
                            + "Muchas Gracias por Preferir Turismo Real !"
                            + "";

                    SendMail.send(m, sub, messg);

                    if (request.getAttribute("msg").toString().contains("correctamente")) {
                        acceso = index;
                        serv.listarServicios(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("id", request.getParameter("id"));
                        request.setAttribute("id_reserva", request.getParameter("id_reserva"));
                        request.getRequestDispatcher(acceso).forward(request, response);

                    } else {
                        //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                        request.setAttribute("error", request.getAttribute("msg"));
                        acceso = index;
                        serv.listarServicios(Integer.parseInt(request.getParameter("id")));
                        request.setAttribute("id", request.getParameter("id"));
                        request.setAttribute("id_reserva", request.getParameter("id_reserva"));
                        request.getRequestDispatcher(acceso).forward(request, response);
                    }
                } else {
                    //Si hay campos en blanco, la página se vuelve a cargar
                    request.setAttribute("error", "Falta seleccionar un dato a contratar");
                    acceso = index;
                    serv.listarServicios(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("id", request.getParameter("id"));
                    request.setAttribute("id_reserva", request.getParameter("id_reserva"));
                    request.getRequestDispatcher(acceso).forward(request, response);

                }
            } catch (Exception ex) {
                request.setAttribute("error", "Error :" + ex.toString());
                acceso = index;
                serv.listarServicios(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("id", request.getParameter("id"));
                request.setAttribute("id_reserva", request.getParameter("id_reserva"));
                request.getRequestDispatcher(acceso).forward(request, response);

            } finally {
                out.close();
            }

        } else {
            acceso = index;
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
