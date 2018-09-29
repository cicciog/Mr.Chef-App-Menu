package ristoranteServices;

import com.google.gson.Gson;
import dataAccessObject.JDBCdessertDAO;
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
@Path("DessertService")
public class DessertServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DessertServiceResource
     */
    public DessertServiceResource() {
    }

    /**
     * 
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDessert() {
        Gson g = new Gson();
        
        return Response.status(400).entity(g.toJson("")).build();
    }

    /**
     * 
     * @return recupera lista dei dessert
     */
    @GET
    @Path("json/listaDessert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaDessert() {
        Gson g = new Gson();
        JDBCdessertDAO dessertDAO = new JDBCdessertDAO();
        return Response.status(200).entity(g.toJson(dessertDAO.getListaDessert())).build();
    }
    
    /**
     * 
     * @return recupera un dessert in base al suo ID
     */
    @GET
    @Path("json/dessert/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer pId) {
        Gson g = new Gson();
        JDBCdessertDAO dessertDAO = new JDBCdessertDAO();
        return Response.status(200).entity(g.toJson(dessertDAO.getDessert(pId))).build();
    }
}
