package com.wk.dao;

import com.wk.model.Train;

import java.util.List;

public interface TrainDao {
    int addTrain(Train train);
    int updateTrain(Train train);
    int delTrain(Train train);
    Train getTrainById(Integer id);
    List<Train> getALLTrains();
    List<Train> getTrainByState(Integer state);

}
