package seapps.abstraction.core.mapper;

import org.apache.ibatis.annotations.*;
import seapps.abstraction.core.domain.Relation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RelationMapper extends BaseMapper<Relation, Long> {
    Relation insert(Relation relation);

    @Select("select * from relation where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type"),
            @Result(property = "componentsTo",
                    column = "component_to_id",
                    one = @One(select = "getOne")),
            @Result(property = "componentFrom",
                    column = "component_from_id",
                    one = @One(select = "getOne"))
    })
    Relation getOne(@Param("id") Long id);

    @Select("select * from relation where component_to_id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type"),
            @Result(property = "componentsTo",
                    column = "component_to_id",
                    one = @One(select = "getOne")),
            @Result(property = "componentFrom",
                    column = "component_from_id",
                    one = @One(select = "getOne"))
    })
    List<Relation> getByComponentTo(@Param("component_to_id") UUID id);

    @Select("select * from relation where component_to_id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "type", column = "type"),
            @Result(property = "componentsTo",
                    column = "component_to_id",
                    one = @One(select = "getOne")),
            @Result(property = "componentFrom",
                    column = "component_from_id",
                    one = @One(select = "getOne"))
    })
    List<Relation> getByComponentFrom(@Param("component_from_id") UUID id);
}