package seapps.abstraction.core.fasade;

import seapps.abstraction.core.dao.RelationDAO;
import seapps.abstraction.core.domain.Relation;
import seapps.abstraction.core.dto.SimpleRelationResponse;
import seapps.abstraction.core.exception.EntityNotFoundException;
import seapps.abstraction.core.mapper.RelationMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class RelationFasade {

    private RelationDAO relationDAO;

    @Inject
    public RelationFasade(RelationDAO relationDAO){
        this.relationDAO = relationDAO;
    }

    public SimpleRelationResponse addRelation(UUID innerComponentId, UUID outerComponentId, String type) throws EntityNotFoundException {
        Relation relation = new Relation(innerComponentId, outerComponentId, type);
        relationDAO.insert(relation);
        return new SimpleRelationResponse(relation);
    }
}