/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.DepartamentoService;
import Modelo.InventarioService;
import Modelo.ReservasService;
import Modelo.SendMail;
import Modelo.ServicioService;
import Modelo.TransporteService;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class SrvMisReservas extends HttpServlet {
    
    String detalle="detalleasignacioncli.jsp";
    String servdeptos = "servdeptos.jsp";
    String ficha = "fichareserva.jsp";
    String servicio = "misservicios.jsp";
    String reservas = "misreservas.jsp";
    //  String reservas = "prueba.jsp";
    String index = "indexcliente.jsp";
    String acceso = "";
    ReservasService reser = new ReservasService();
    ServicioService srv = new ServicioService();
    InventarioService inv = new InventarioService();
    DepartamentoService dep = new DepartamentoService();
    TransporteService ts=new TransporteService();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        if (accion.equals("reservas")) {
            acceso = reservas;
            reser.listarReservas(request.getParameter("rut"));
            request.setAttribute("rut", request.getParameter("rut"));
        } else if (accion.equals("servicios")) {
            acceso = servicio;
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("id_reserva", request.getParameter("id_reserva"));
        } else if (accion.equals("servdeptos")) {
            acceso = servdeptos;
            srv.listarServicios(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("id_reserva", request.getParameter("id_reserva"));
        } else if (accion.equals("ficha")) {
            acceso = ficha;
            inv.listarInventario(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("id_reserva", request.getParameter("id_reserva"));
        } else if (accion.equals("detalle")) {
            acceso = detalle;
            ts.detalleasignacion(Integer.parseInt(request.getParameter("id_solicitud")));
        } else if (accion.equals("eliminar")) {

            try {
                if (request.getParameter("id_reserva") != null) {

                    /*Validando que todos los campos no están vacíos, invocamos el método para ingresar
                 un nuevo usuario con la función crearUsuario()  
                     */
                    request.setAttribute("msg",
                            reser.eliminarReserva(Integer.parseInt(request.getParameter("id_reserva")))
                    );

                    dep.actualizarestadodepartamento(Integer.parseInt(request.getParameter("id_departamento")),
                            request.getParameter("habilitado"));

                    String m = request.getParameter("correo");
                    String sub = "Turismo Real >> Reserva Anulada Correctamente";

                    String messg = "Estimado Cliente , \n"
                            + "\n"
                            + "Se informa que la reserva " + request.getParameter("id_reserva") + " ha sido anulada correctamente  \n"
                            + "-------------------------------------------------------------------------------------------------------------------\n"
                            + "\n"
                            + "Muchas Gracias por Preferir Turismo Real !\n"
                            + "";

                    SendMail.send(m, sub, messg);

                    if (request.getAttribute("msg").toString().contains("correctamente")) {
                        request.getRequestDispatcher("misreservas.jsp").forward(request, response);
                    } else {
                        //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                        request.setAttribute("error", request.getAttribute("msg"));
                        request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
                    }
                } else {
                    //Si hay campos en blanco, la página se vuelve a cargar
                    request.setAttribute("error", "Falta seleccionar reserva a anular");
                    request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                request.setAttribute("error", "Error :" + ex.toString());
                request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
            } finally {
                out.close();
            }

        } else {
            acceso = index;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);
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
