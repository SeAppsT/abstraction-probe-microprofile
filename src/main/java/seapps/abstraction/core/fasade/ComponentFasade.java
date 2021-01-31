package seapps.abstraction.core.fasade;

import org.apache.ibatis.session.TransactionIsolationLevel;
import seapps.abstraction.core.config.SessionFactoryBuilder;
import seapps.abstraction.core.dao.ComponentDAO;
import seapps.abstraction.core.dao.DAO;
import seapps.abstraction.core.domain.Component;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.dto.ComponentResponse;
import seapps.abstraction.core.dto.SimpleComponentResponse;
import seapps.abstraction.core.exception.EntityNotFoundException;
import seapps.abstraction.core.mapper.ComponentMapper;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class ComponentFasade {

    private ComponentDAO componentDAO;

    @Inject
    public ComponentFasade(ComponentDAO componentDAO){
        this.componentDAO = componentDAO;
    }

    @PostConstruct
    public void start() throws EntityNotFoundException {
        getOneComponent(UUID.randomUUID());
    }

    public ComponentResponse getOneComponent(UUID id) throws EntityNotFoundException {
        Component component = componentDAO.execute(
                mapper -> mapper.getOne(id)
        ).orElseThrow(EntityNotFoundException::new);
        return new ComponentResponse(component);
    }

    public SimpleComponentResponse addComponent(ComponentRequest componentRequest, UUID outerComponentId) throws EntityNotFoundException {
        Component component = new Component(componentRequest);
        component.attachComponent(outerComponentId,
                componentRequest.x, componentRequest.y);

        componentDAO.complete(TransactionIsolationLevel.READ_COMMITTED);
        return new SimpleComponentResponse(component);
    }
}