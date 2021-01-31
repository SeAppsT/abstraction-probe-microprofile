package seapps.abstraction.core.dto;

import seapps.abstraction.core.domain.Component;

public class RelationResponse {
    public Long id;
    public SimpleComponentResponse innerComponent;
    public SimpleComponentResponse outerComponentId;
    public String type;
}