package seapps.abstraction.core.dao;

import seapps.abstraction.core.domain.Component;
import seapps.abstraction.core.mapper.ComponentMapper;

import javax.inject.Singleton;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class ComponentDAO extends DAO<Component, ComponentMapper>{

    public Optional<Component> insertAndGet(Component component){
        return super.execute(mapper -> mapper.insert(component));
    }

    public void insert(Component component){
        actions.add(mapper -> mapper.insert(component));
    }

    public Optional<Component> getOne(UUID id){
        return super.execute(mapper -> mapper.getOne(id));
    }
}