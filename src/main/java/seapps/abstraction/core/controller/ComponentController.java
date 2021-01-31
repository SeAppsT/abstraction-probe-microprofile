package seapps.abstraction.core.controller;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.dto.ComponentResponse;
import seapps.abstraction.core.dto.SimpleComponentResponse;
import seapps.abstraction.core.exception.EntityNotFoundException;
import seapps.abstraction.core.fasade.ComponentFasade;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.UUID;

@Path("/component")
@Singleton

public class ComponentController {

    private ComponentFasade componentFasade;

    @Inject
    public ComponentController(ComponentFasade componentFasade){
        this.componentFasade = componentFasade;
    }

    @GET
    @Path("/{id}")
    public ComponentResponse getComponent(@PathParam("id") UUID id) throws EntityNotFoundException {
        return componentFasade.getOneComponent(id);
    }

    @POST
    @Path("/{id}")
    public SimpleComponentResponse addComponent(@PathParam("id") UUID outerComponentId,
                                                @RequestBody ComponentRequest componentRequest) throws EntityNotFoundException {
        return componentFasade.addComponent(componentRequest, outerComponentId);
    }
}