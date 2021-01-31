package seapps.abstraction.core.dao;

import seapps.abstraction.core.domain.Relation;
import seapps.abstraction.core.mapper.RelationMapper;

import javax.inject.Singleton;

@Singleton
public class RelationDAO extends DAO<Relation, RelationMapper>{
    public void insert(Relation relation){
        super.execute(mapper -> mapper.insert(relation));
    }
}