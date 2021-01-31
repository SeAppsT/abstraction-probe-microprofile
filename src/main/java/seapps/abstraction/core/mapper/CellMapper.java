package seapps.abstraction.core.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import seapps.abstraction.core.domain.Cell;

public interface CellMapper extends BaseMapper<Cell, Long> {
    @Select("select * from cell where relation_id = #{relationId}, x = #{x}, y = #{y}")
    Cell getCurrentCell(@Param("x") Integer x, @Param("y") Integer y,
                        @Param("relationId") Long relationId);

    @Insert("insert into cell (x, y, relation_id) values (#{x}, #{y}, #{relationId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Cell insert(Cell cell);
}