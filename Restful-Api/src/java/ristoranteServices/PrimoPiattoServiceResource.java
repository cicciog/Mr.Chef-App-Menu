package ristoranteServices;

import com.google.gson.Gson;
import dataAccessObject.JDBCprimoPiattoDAO;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ciccio
 */
@Path("primoPiattoService")
public class PrimoPiattoServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PrimoPiattoServiceResource
     */
    public PrimoPiattoServiceResource() {
    }

    /**
     * 
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrimiPiatti() {
        Gson g = new Gson();
        
        return Response.status(400).entity(g.toJson("")).build();
    }

    /**
     * 
     * @return recupera lista dei primi piatti
     */
    @GET
    @Path("json/listaPrimiPiatti")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaPrimiPiatti() {
        Gson g = new Gson();
        JDBCprimoPiattoDAO primoPiattoDAO = new JDBCprimoPiattoDAO();
        return Response.status(200).entity(g.toJson(primoPiattoDAO.getListaPrimiPiatti())).build();
    }
    
    /**
     * 
     * @return recupera un primo piatto in base al suo ID
     */
    @GET
    @Path("json/primoPiatto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer pId) {
        Gson g = new Gson();
        JDBCprimoPiattoDAO primoPiattoDAO = new JDBCprimoPiattoDAO();
        return Response.status(200).entity(g.toJson(primoPiattoDAO.getPrimoPiatto(pId))).build();
    }
}
