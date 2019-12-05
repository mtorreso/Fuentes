/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.DepartamentoService;
import Modelo.ReservasService;
import Modelo.SendMail;
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
public class NuevaReservac extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    ReservasService reser = new ReservasService();
    DepartamentoService dep = new DepartamentoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            if (request.getParameter("fecha_reserva") != null && !request.getParameter("fecha_reserva").isEmpty()
                    && request.getParameter("cantidad_personas") != null && !request.getParameter("cantidad_personas").isEmpty()
                    && request.getParameter("fecha_salida") != null && !request.getParameter("fecha_salida").isEmpty()
                    && request.getParameter("rut") != null && !request.getParameter("rut").isEmpty()) {

                /*Validando que todos los campos no están vacíos, invocamos el método para ingresar
                 una nueva reserva con la función agregarReserva()  
                 */
                request.setAttribute("msg",
                        reser.agregarReserva(
                                request.getParameter("fecha_reserva"),
                                request.getParameter("cantidad_personas"),
                                request.getParameter("fecha_salida"),
                                request.getParameter("rut"),
                                request.getParameter("id_departamento")
                        )
                );
                dep.actualizarestadodepartamento(Integer.parseInt(request.getParameter("id_departamento")),
                        request.getParameter("habilitado"));

                String m = request.getParameter("correo");
                String sub = "Turismo Real >> Reserva Generada Correctamente";

                String messg = "Estimado Cliente , \n"
                        + "\n"
                        + "Se informa que su reserva ha sido generada correctamente \n"
                        + "Fecha Reserva     : "+request.getParameter("fecha_reserva")+"\n"
                        + "Fecha Salida      : "+ request.getParameter("fecha_salida")+"\n"
                        + "Cantidad Personas : "+ request.getParameter("cantidad_personas")+"\n"
                        + "\n"
                        + "-------------------------------------------------------------------------------------------------\n"
                        + "Departamento :"+request.getParameter("departamento")+"\n"
                        + "Dirección :  "+request.getParameter("direccion")+"//"+request.getParameter("ubicacion")+"\n"
                        + "Dormitorios :"+request.getParameter("dormitorios")+"\n"
                        + "Baños : "+request.getParameter("banos")+"\n"
                        + "Valor Arriendo :"+request.getParameter("valor")+"\n"
                        + "\n"
                        + "\n"
                        + "-------------------------------------------------------------------------------------------------\n"
                        + "\n"
                        + "Muchas Gracias por Preferir Turismo Real !";
                SendMail.send(m, sub, messg);
                if (request.getAttribute("msg").toString().contains("correctamente")) {
                    request.getRequestDispatcher("reportereserva.jsp").forward(request, response);

                } else {
                    //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                    request.setAttribute("error", request.getAttribute("msg"));
                    request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
                }
            } else {
                //Si hay campos en blanco, la página se vuelve a cargar
                request.setAttribute("error", "Debe llenar todos los campos");
                request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Error :" + ex.toString());
            request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
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
