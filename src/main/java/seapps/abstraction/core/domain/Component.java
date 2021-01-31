package seapps.abstraction.core.domain;

import seapps.abstraction.core.dao.CellDAO;
import seapps.abstraction.core.dao.ComponentDAO;
import seapps.abstraction.core.dao.RelationDAO;
import seapps.abstraction.core.dto.ComponentRequest;
import seapps.abstraction.core.exception.EntityNotFoundException;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class Component {
    private UUID id;
    private String name;
    private String color;
    private List<Relation> relationsTo;
    private List<Relation> relationsFrom;

    private ComponentDAO componentDAO;
    private RelationDAO relationDAO;
    private CellDAO cellDAO;

    @Inject
    public Component(ComponentDAO componentDAO, RelationDAO relationDAO, CellDAO cellDAO){
        this.componentDAO = componentDAO;
        this.relationDAO = relationDAO;
        this.cellDAO = cellDAO;
    }

    public Component(ComponentRequest componentRequest){
        this.name = componentRequest.name;
        this.color = componentRequest.color;
        componentDAO.insert(this);
    }

    public void attachComponent(UUID componentId, Integer x, Integer y) throws EntityNotFoundException {
        Relation relation = new Relation(this.id, componentId, "abstraction");
        relationDAO.insert(relation);
        Cell cell = new Cell(relation, x, y);
        cellDAO.insert(cell);
    }
}