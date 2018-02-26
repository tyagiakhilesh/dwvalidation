import io.dropwizard.testing.junit.ResourceTestRule;
import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MyResourceTest {

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new MyResource())
            .build();

    @Test
    public void testWorkUnitBatchPostAPI() {
        Invocation.Builder builder = resources.target("/v1/resource").request();
        MyRep rep = new MyRep();
        Response response = builder.post(Entity.entity(rep, MediaType.APPLICATION_JSON_TYPE));
        System.out.println("Response status code is: " + response.getStatus());
        Assertions.assertThat(response.getStatus()).isNotEqualTo(Response.Status.OK.getStatusCode());
        Assertions.assertThat(response.getStatus()).isEqualTo(422);
    }
}
