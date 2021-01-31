package seapps.abstraction.core.dao;

import seapps.abstraction.core.domain.Cell;
import seapps.abstraction.core.mapper.CellMapper;

import javax.inject.Singleton;

@Singleton
public class CellDAO extends DAO<Cell, CellMapper> {
    public void insert(Cell cell){
        super.execute(mapper -> mapper.insert(cell));
    }
}