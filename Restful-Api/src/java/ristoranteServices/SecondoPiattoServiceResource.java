package ristoranteServices;

import com.google.gson.Gson;
import dataAccessObject.JDBCsecondoPiattoDAO;
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
@Path("secondoPiattoService")
public class SecondoPiattoServiceResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SecondPiattoServiceResource
     */
    public SecondoPiattoServiceResource() {
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
     * @return recupera lista dei secondi piatti
     */
    @GET
    @Path("json/listaSecondiPiatti")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaPrimiPiatti() {
        Gson g = new Gson();
        JDBCsecondoPiattoDAO secondoPiattoDAO = new JDBCsecondoPiattoDAO();
        return Response.status(200).entity(g.toJson(secondoPiattoDAO.getListaSecondiPiatti())).build();
    }
    
    /**
     * 
     * @return recupera un secondo piatto in base al suo ID
     */
    @GET
    @Path("json/secondoPiatto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer pId) {
        Gson g = new Gson();
        JDBCsecondoPiattoDAO secondoPiattoDAO = new JDBCsecondoPiattoDAO();
        return Response.status(200).entity(g.toJson(secondoPiattoDAO.getSecondoPiatto(pId))).build();
    }
}
