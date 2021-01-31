package seapps.abstraction.core.dto;


import seapps.abstraction.core.domain.Component;
import seapps.abstraction.core.domain.Relation;

import java.util.List;
import java.util.UUID;

public class ComponentResponse {
    public UUID id;
    public String name;
    public String color;
    public List<Relation> relationsTo;
    public List<Relation> relationsFrom;

    public ComponentResponse(Component component){

    }
}