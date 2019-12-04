/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.CuentasService;
import Modelo.DepartamentoService;
import Modelo.InventarioService;
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
public class Eliminarinventario extends HttpServlet {

    String index = "departamentos.jsp";
    String acceso = "";
    InventarioService inv = new InventarioService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        if (accion.equals("eliminar")) {

            try {
                if (request.getParameter("id") != null) {

                    request.setAttribute("msg",
                            inv.eliminarinventario(Integer.parseInt(request.getParameter("id")))
                    );

                    if (request.getAttribute("msg").toString().contains("correctamente")) {
                        request.getRequestDispatcher("departamentos.jsp").forward(request, response);
                    } else {
                        //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                        request.setAttribute("error", request.getAttribute("msg"));
                        request.getRequestDispatcher("departamentos.jsp").forward(request, response);
                    }
                } else {
                    //Si hay campos en blanco, la página se vuelve a cargar
                    request.setAttribute("error", "Falta seleccionar un dato a eliminar");
                    request.getRequestDispatcher("departamentos.jsp").forward(request, response);
                }
            } catch (Exception ex) {
                request.setAttribute("error", "Error :" + ex.toString());
                request.getRequestDispatcher("departamentos.jsp").forward(request, response);
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
