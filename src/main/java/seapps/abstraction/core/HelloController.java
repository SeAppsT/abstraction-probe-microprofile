package seapps.abstraction.core;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

    @GET
    public Object sayHello() {
        return new Object();
    }
}