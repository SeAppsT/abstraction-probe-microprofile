package seapps.abstraction.core.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        containerRequestContext.abortWith(
                Response.status(Response.Status.FORBIDDEN)
                        .entity("Unauthorized").build());
    }
}