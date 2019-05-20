package com.wk.dao;

import com.wk.model.Position;

import java.util.List;

public interface PositionDao {
    int addPosition(Position position);
    int delPosition(Position position);
    int updatePosition(Position position);
    Position getPositionById(Integer id);
    Position getPositionByName(String name);
    List<Position> getPositionByDepid(Integer depid);
}
