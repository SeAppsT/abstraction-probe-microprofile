package seapps.abstraction.core.mapper;

import org.apache.ibatis.annotations.*;
import seapps.abstraction.core.domain.Component;

import java.util.List;
import java.util.UUID;

public interface ComponentMapper extends BaseMapper<Component, UUID> {

    @Select("select * from Component where id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "color", column = "color"),
            @Result(property = "relationsTo", javaType = List.class,
                many = @Many(select = "getByComponentTo"))
    })
    Component getOne(@Param("id") UUID id);

    @Insert("insert into component values (name, color) values (#{name}, #{color})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Component insert(Component component);
}