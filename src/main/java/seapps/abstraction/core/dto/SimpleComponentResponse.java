package seapps.abstraction.core.dto;

import seapps.abstraction.core.domain.Component;

import java.util.UUID;

public class SimpleComponentResponse {
    public UUID id;
    public String name;
    public String color;

    public SimpleComponentResponse(Component component){

    }
}