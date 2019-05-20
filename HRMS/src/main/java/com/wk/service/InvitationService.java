package com.wk.service;

import com.wk.model.Invitation;

import java.util.List;

public interface InvitationService {
    boolean addInvitation(Invitation invitation);
    boolean delInvitation(Invitation invitation);
    boolean updateInvitation(Invitation invitation);
    List<Invitation> getInvitationByState(Integer state);
    List<Invitation> getInvitationByVid(Integer vid);
    Invitation getInvitationById(Integer id);
}
