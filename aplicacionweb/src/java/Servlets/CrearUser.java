package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.CuentasService;
import Modelo.SendMail;

public class CrearUser extends HttpServlet {

    CuentasService usu = new CuentasService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("rut") != null && !request.getParameter("rut").isEmpty()
                    && request.getParameter("nombre") != null && !request.getParameter("nombre").isEmpty()
                    && request.getParameter("correo") != null && !request.getParameter("correo").isEmpty()
                    && request.getParameter("telefono") != null && !request.getParameter("telefono").isEmpty()
                    && request.getParameter("clave") != null && !request.getParameter("clave").isEmpty()
                    && request.getParameter("id_rol") != null && !request.getParameter("id_rol").isEmpty()) {


                /*Validando que todos los campos no están vacíos, invocamos el método para ingresar
                 un nuevo usuario con la función crearUsuario()  
                 */
                request.setAttribute("msg",
                        usu.crearCuenta(
                                request.getParameter("rut"),
                                request.getParameter("nombre"),
                                request.getParameter("correo"),
                                request.getParameter("telefono"),
                                request.getParameter("clave"),
                                Integer.parseInt(request.getParameter("id_rol"))));
                
                String m = request.getParameter("correo");
                String sub = "Bienvenido a Turismo Real : " + request.getParameter("nombre");

                String messg = "Estimado "+request.getParameter("nombre")+" \n"
                        + "Se ha creado su cuenta correctamente , sus datos son \n"
                        + "\n"
                        + "Email :"+request.getParameter("correo")+" \n"
                         + "Clave :"+request.getParameter("clave")+" \n"
                        + "\n"
                        + "Gracias por preferir Turismo Real !!";

                SendMail.send(m, sub, messg);
                
                if (request.getAttribute("msg").toString().contains("correctamente")) {
                    request.getRequestDispatcher("Crear_user.jsp").forward(request, response);
                } else {
                    //Redireccionamos a la misma página para que lo vuelva a intentar si algún error ocurre
                    request.setAttribute("error", request.getAttribute("msg"));
                    request.getRequestDispatcher("Crear_user.jsp").forward(request, response);
                }
            } else {
                //Si hay campos en blanco, la página se vuelve a cargar
                request.setAttribute("error", "Debe llenar todos los campos");
                request.getRequestDispatcher("Crear_user.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Error :" + ex.toString());
            request.getRequestDispatcher("Crear_user.jsp").forward(request, response);
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
