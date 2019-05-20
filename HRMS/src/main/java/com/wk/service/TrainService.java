package com.wk.service;

import com.wk.model.Train;

import java.util.List;

public interface TrainService {
    boolean addTrain(Train train);
    boolean updateTrain(Train train);
    boolean delTrain(Train train);
    Train getTrainById(Integer id);
    List<Train> getTrainByEmpid(Integer empid);
    List<Train> getALLTrains();
    List<Train> getTrainByState(Integer state);
}
