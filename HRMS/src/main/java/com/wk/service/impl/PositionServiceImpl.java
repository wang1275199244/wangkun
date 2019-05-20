package com.wk.service.impl;

import com.wk.dao.PositionDao;
import com.wk.model.Position;
import com.wk.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    public boolean addPosition(Position position) {
        if(position == null){
            return false;
        }
        int row = positionDao.addPosition(position);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delPosition(Position position) {
        if(position == null){
            return false;
        }
        int row = positionDao.delPosition(position);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updatePosition(Position position) {
        if(position == null){
            return false;
        }
        int row = positionDao.updatePosition(position);
        if(row != 0){
            return true;
        }
        return false;
    }

    public Position getPositionById(Integer id) {
        if(id == null||id == 0){
            return null;
        }
        return positionDao.getPositionById(id);
    }

    public Position getPositionByName(String name) {
        if(name == null){
            return null;
        }
        return positionDao.getPositionByName(name);
    }

    public List<Position> getPositionByDepid(Integer depid) {
        if(depid == null||depid == 0){
            return null;
        }
        return positionDao.getPositionByDepid(depid);
    }
}
