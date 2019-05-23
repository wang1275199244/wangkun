package com.wk.dao;

import com.wk.model.RewardPunishment;

import java.util.List;

public interface RewardPunishmentDao {
    int addRewardPunishment(RewardPunishment rewardPunishment);
    int delRewardPunishment(RewardPunishment rewardPunishment);
    int updateRewardPunishment(RewardPunishment rewardPunishment);
    List<RewardPunishment> getRewardPunishmentByEmpid(Integer empid);
    List<RewardPunishment> getRewardPunishmentByEmpidAndDate(Integer empid,String date);
}
