package com.wk.service.impl;

import com.wk.dao.RewardPunishmentDao;
import com.wk.model.RewardPunishment;
import com.wk.service.RewardPunishmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("rewardPunishmentService")
public class RewardPunishmentServiceImpl implements RewardPunishmentService {
    @Resource
    private RewardPunishmentDao rpDao;

    public boolean addRewardPunishment(RewardPunishment rewardPunishment) {
        if(rewardPunishment == null){
            return false;
        }
        int row = rpDao.addRewardPunishment(rewardPunishment);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean delRewardPunishment(RewardPunishment rewardPunishment) {
        if(rewardPunishment == null){
            return false;
        }
        int row = rpDao.delRewardPunishment(rewardPunishment);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateRewardPunishment(RewardPunishment rewardPunishment) {
        if(rewardPunishment == null){
            return false;
        }
        int row = rpDao.updateRewardPunishment(rewardPunishment);
        if(row != 0){
            return true;
        }
        return false;
    }

    public List<RewardPunishment> getRewardPunishmentByEmpid(Integer empid) {
        if(empid == null&&empid == 0){
            return null;
        }
        return rpDao.getRewardPunishmentByEmpid(empid);
    }
}
