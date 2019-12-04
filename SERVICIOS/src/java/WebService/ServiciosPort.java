/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author torre
 */
@Path("serviciosport")
public class ServiciosPort {

    private WebService_client.Servicios port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiciosPort
     */
    public ServiciosPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method listardepartamentos
     * @return an instance of javax.xml.bind.JAXBElement<WebService_client.ListardepartamentosResponse>
     */
    @GET
    @Produces("application/xml")
    @Consumes("text/plain")
    @Path("listardepartamentos/")
    public JAXBElement<WebService_client.ListardepartamentosResponse> getListardepartamentos() {
        try {
            // Call Web Service Operation
            if (port != null) {
                java.util.List<WebService_client.Departamento> result = port.listardepartamentos();

                class ListardepartamentosResponse_1 extends WebService_client.ListardepartamentosResponse {

                    ListardepartamentosResponse_1(java.util.List<WebService_client.Departamento> _return) {
                        this._return = _return;
                    }
                }
                WebService_client.ListardepartamentosResponse response = new ListardepartamentosResponse_1(result);
                return new WebService_client.ObjectFactory().createListardepartamentosResponse(response);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private WebService_client.Servicios getPort() {
        try {
            // Call Web Service Operation
            WebService_client.Servicios_Service service = new WebService_client.Servicios_Service();
            WebService_client.Servicios p = service.getServiciosPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
