package Servlets;

import Modelo.CuentasService;
import Modelo.DepartamentoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Modificadepartamento extends HttpServlet {

    DepartamentoService depto = new DepartamentoService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("fecha") != null && !request.getParameter("fecha").isEmpty()
                    && request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty()
                    && request.getParameter("ubicacion") != null && !request.getParameter("ubicacion").isEmpty()
                    && request.getParameter("direccion") != null && !request.getParameter("direccion").isEmpty()
                    && request.getParameter("banos") != null && !request.getParameter("banos").isEmpty()
                    && request.getParameter("habitaciones") != null && !request.getParameter("habitaciones").isEmpty()
                    && request.getParameter("valorarriendo") != null && !request.getParameter("valorarriendo").isEmpty()
                    && request.getParameter("descripcion") != null && !request.getParameter("descripcion").isEmpty()) {


                /*Validando que todos los campos no están vacíos, invocamos el método para modificar
                  un nuevo usuario con la función modificarUsuario()  
                 */
                request.setAttribute("msg",
                        depto.actualizardepartamento(Integer.parseInt(request.getParameter("id")),
                                request.getParameter("nombre"),
                                request.getParameter("ubicacion"),
                                request.getParameter("banos"),
                                request.getParameter("habitaciones"),
                                request.getParameter("valorarriendo"),
                                request.getParameter("descripcion"),
                                request.getParameter("fecha"),
                                request.getParameter("direccion")
                                ));

                if (request.getAttribute("msg").toString().contains("correctamente")) {
                    request.getRequestDispatcher("departamentos.jsp").forward(request, response);
                } else {

                    request.setAttribute("error", request.getAttribute("msg"));
                    request.getRequestDispatcher("departamentos.jsp").forward(request, response);
                }
            } else {
                //Si hay campos en blanco, la página se vuelve a cargar
                request.setAttribute("error", "Debe llenar todos los campos");
                request.getRequestDispatcher("departamentos.jsp").forward(request, response);
            }

        } catch (Exception ex) {
            request.setAttribute("error", "Error :" + ex.toString());
            request.getRequestDispatcher("departamentos.jsp").forward(request, response);
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
