package com.wk.service;

import com.wk.model.Position;

import java.util.List;

public interface PositionService {
    boolean addPosition(Position position);
    boolean delPosition(Position position);
    boolean updatePosition(Position position);
    Position getPositionById(Integer id);
    Position getPositionByName(String name);
    List<Position> getPositionByDepid(Integer depid);
}
