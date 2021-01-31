package seapps.abstraction.core.mapper;

import java.util.Optional;

public interface BaseMapper<T, ID> {
    T insert(T entity);
    T getOne(ID id);
}