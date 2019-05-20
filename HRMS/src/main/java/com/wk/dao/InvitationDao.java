package com.wk.dao;

import com.wk.model.Invitation;

import java.util.List;

public interface InvitationDao {
    int addInvitation(Invitation invitation);
    int delInvitation(Invitation invitation);
    int updateInvitation(Invitation invitation);
    List<Invitation> getInvitationByState(Integer state);
    List<Invitation> getInvitationByVid(Integer vid);
    Invitation getInvitationById(Integer id);
}
