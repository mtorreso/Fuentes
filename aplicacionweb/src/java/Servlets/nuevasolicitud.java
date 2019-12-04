package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.SendMail;
import Modelo.TransporteService;

public class nuevasolicitud extends HttpServlet {

    TransporteService ts = new TransporteService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("fecha_solicitud") != null && !request.getParameter("fecha_solicitud").isEmpty()
                    && request.getParameter("origen") != null && !request.getParameter("origen").isEmpty()
                    && request.getParameter("destino") != null && !request.getParameter("destino").isEmpty()) {


                /*Validando que todos los campos no están vacíos, invocamos el método para ingresar
                 un nuevo usuario con la función crearUsuario()  
                 */
                request.setAttribute("msg",
                        ts.nuevasolicitud(request.getParameter("id_reserva"),
                                request.getParameter("fecha_solicitud"),
                                request.getParameter("hora_solicitud"),
                                request.getParameter("origen"),
                                request.getParameter("destino") ));

                String m = request.getParameter("correo");
                String sub = "Solicitud de Transporte Enviada Correctamente";
                String messg = "Estimado Cliente se informa que su solicitud  ha sido recepcioada correctamente. "
                        + "En las proximas 24 horas el administrador le asignara un transporte. "
                        
                        + "Muchas gracias por preferir Turismo Real!";

                SendMail.send(m, sub, messg);

                if (request.getAttribute("msg").toString().contains("correctamente")) {
                     request.getRequestDispatcher("indexcliente.jsp").forward(request, response);
                     
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
    }// </editor-fold>

}
