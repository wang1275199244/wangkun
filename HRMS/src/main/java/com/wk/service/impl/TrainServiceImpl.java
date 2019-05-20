package com.wk.service.impl;

import com.wk.dao.TrainDao;
import com.wk.model.Train;
import com.wk.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("trainService")
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainDao trainDao;

    public boolean addTrain(Train train) {
        if(train == null){
            return false;
        }
        int row = trainDao.addTrain(train);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateTrain(Train train) {
        if(train == null){
            return false;
        }
        int row = trainDao.updateTrain(train);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delTrain(Train train) {
        if(train == null){
            return false;
        }
        int row = trainDao.delTrain(train);
        if(row != 0){
            return true;
        }
        return false;
    }

    public Train getTrainById(Integer id) {
        if(id == null){
            return null;
        }
        return trainDao.getTrainById(id);
    }

    public List<Train> getTrainByEmpid(Integer empid) {
        if(empid == null){
            return null;
        }
        return trainDao.getTrainByEmpid(empid);
    }

    public List<Train> getALLTrains() {
        return trainDao.getALLTrains();
    }

    public List<Train> getTrainByState(Integer state) {
        if(state == null){
            return null;
        }
        return trainDao.getTrainByState(state);
    }
}
