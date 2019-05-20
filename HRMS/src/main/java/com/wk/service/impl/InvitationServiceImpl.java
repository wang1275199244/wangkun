package com.wk.service.impl;

import com.wk.dao.InvitationDao;
import com.wk.model.Invitation;
import com.wk.service.InvitationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("invitationService")
public class InvitationServiceImpl implements InvitationService {
    @Resource
    private InvitationDao invitationDao;

    public boolean addInvitation(Invitation invitation) {
       if(invitation == null){
           return false;
       }
        int row = invitationDao.addInvitation(invitation);
       if(row != 0){
           return true;
       }
       return false;
    }

    public boolean delInvitation(Invitation invitation) {
        if(invitation == null){
            return false;
        }
        int row = invitationDao.delInvitation(invitation);
        if(row != 0){
            return true;
        }
        return false;
    }

    public boolean updateInvitation(Invitation invitation) {
        if(invitation == null){
            return false;
        }
        int row = invitationDao.updateInvitation(invitation);
        if(row != 0){
            return true;
        }
        return false;
    }

    public List<Invitation> getInvitationByState(Integer state) {
        if(state == null){
            return null;
        }
        return invitationDao.getInvitationByState(state);
    }

    public List<Invitation> getInvitationByVid(Integer vid) {
        if(vid == null||vid == 0){
            return null;
        }
        return invitationDao.getInvitationByVid(vid);
    }

    public Invitation getInvitationById(Integer id) {
        if(id == null||id == 0){
            return null;
        }
        return invitationDao.getInvitationById(id);
    }
}
