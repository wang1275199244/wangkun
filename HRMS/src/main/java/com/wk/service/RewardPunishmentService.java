package com.wk.service;

import com.wk.model.RewardPunishment;

import java.util.List;

public interface RewardPunishmentService {
    boolean addRewardPunishment(RewardPunishment rewardPunishment);
    boolean delRewardPunishment(RewardPunishment rewardPunishment);
    boolean updateRewardPunishment(RewardPunishment rewardPunishment);
    List<RewardPunishment> getRewardPunishmentByEmpid(Integer empid);
    List<RewardPunishment> getRewardPunishmentByEmpidAndDate(RewardPunishment rewardPunishment);
}
