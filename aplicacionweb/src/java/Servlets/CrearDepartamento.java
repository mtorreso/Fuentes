/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.DepartamentoService;
import Modelo.SendMail;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class CrearDepartamento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    DepartamentoService depto = new DepartamentoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            if (request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty()
                    && request.getParameter("ubicacion") != null && !request.getParameter("ubicacion").isEmpty()
                    && request.getParameter("banos") != null && !request.getParameter("banos").isEmpty()
                    && request.getParameter("habitaciones") != null && !request.getParameter("habitaciones").isEmpty()
                    && request.getParameter("valorarriendo") != null && !request.getParameter("valorarriendo").isEmpty()
                    && request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty()
                    && request.getParameter("fecha") != null && !request.getParameter("fecha").isEmpty()
                    && request.getParameter("direccion") != null && !request.getParameter("direccion").isEmpty()) {

                /*Validando que todos los campos no están vacíos, invocamos el método para ingresar
                 un nuevo usuario con la función crearUsuario()  
                 */
                request.setAttribute("msg",
                        depto.agregardepartamento(request.getParameter("nombre"),
                                request.getParameter("ubicacion"),
                                request.getParameter("banos"),
                                request.getParameter("habitaciones"),
                                request.getParameter("valorarriendo"),
                                request.getParameter("descripcion"),
                                request.getParameter("fecha"),
                                request.getParameter("direccion"))
                );

                String m = request.getParameter("correo");
                String sub = "Turismo Real - Nuevo Departamento";


                String messg = "Estimado Usuario \n"
                        + "\n"
                        + "Se informa que se ha registrado un nuevo departamento  con los siguientes datos\n"
                        + "-------------------------------------------------------------------------------------------------------------------\n"
                        + "Fecha Publicación: " + request.getParameter("fecha") + "\n"
                        + "Nombre :           " + request.getParameter("nombre") + "\n"
                        + "Dirección :        " + request.getParameter("direccion") + "/" + request.getParameter("ubicacion") + "\n"
                        + "Baños :            " + request.getParameter("banos") +"\n"
                        + "Dormitorios:       " + request.getParameter("habitaciones") +"\n"
                        + "Valor Arriendo :   " + request.getParameter("valorarriendo") +"\n"
                        + "Detalle :          " + request.getParameter("descripcion") +"\n"
                        + "\n"
                        + "\n"
                        + "-------------------------------------------------------------------------------------------------------------------\n"
                        + "\n"
                        + "Muchas Gracias por Preferir Turismo Real !";
                SendMail.send(m, sub, messg);

                if (request.getAttribute("msg").toString().contains("correctamente")) {
                    request.getRequestDispatcher("departamentos.jsp").forward(request, response);
                } else {
                    //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                    request.setAttribute("error", request.getAttribute("msg"));
                    request.getRequestDispatcher("NuevoDepartamento.jsp").forward(request, response);
                }
            } else {
                //Si hay campos en blanco, la página se vuelve a cargar
                request.setAttribute("error", "Debe llenar todos los campos");
                request.getRequestDispatcher("NuevoDepartamento.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Error :" + ex.toString());
            request.getRequestDispatcher("NuevoDepartamento.jsp").forward(request, response);
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
    }// </editor-fold>

}
