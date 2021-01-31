package seapps.abstraction.core.domain;

import seapps.abstraction.core.mapper.RelationMapper;

import javax.inject.Inject;

public class Cell {
    private Long id;
    private Relation relation;
    private Integer x;
    private Integer y;

    private RelationMapper relationMapper;

    @Inject
    public Cell(RelationMapper relationMapper){
        this.relationMapper = relationMapper;
    }

    public Cell(Long relationId, Integer x, Integer y){

    }

    public Cell(Relation relation, Integer x, Integer y){
        this.relation = relation;
        this.x = x;
        this.y = y;
    }
}