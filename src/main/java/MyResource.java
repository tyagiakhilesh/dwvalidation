import com.codahale.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/resource")
@Produces(MediaType.APPLICATION_JSON)
public class MyResource {

    @POST
    @Timed
    public Response myFunction(@Valid MyRep rep) {
        return Response.ok().build();
    }
}
