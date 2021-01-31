package seapps.abstraction.core.domain;


import seapps.abstraction.core.dao.ComponentDAO;
import seapps.abstraction.core.exception.EntityNotFoundException;

import javax.inject.Inject;
import java.util.UUID;

public class Relation {
    private Long id;
    private Component innerComponent;
    private Component outerComponent;
    private String type;

    private ComponentDAO componentDAO;

    @Inject
    public Relation(ComponentDAO componentDAO){
        this.componentDAO = componentDAO;
    }

    public Relation(){}

    public Relation(UUID innerComponentId, UUID outerComponentId, String type) throws EntityNotFoundException {
        innerComponent = componentDAO.getOne(innerComponentId).orElseThrow(EntityNotFoundException::new);
        outerComponent = componentDAO.getOne(outerComponentId).orElseThrow(EntityNotFoundException::new);
        this.type = type;
    }
}