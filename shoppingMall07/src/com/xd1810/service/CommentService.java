package com.xd1810.service;

import com.xd1810.model.Comment;
import com.xd1810.model.Good;

import java.util.List;

public interface CommentService {
    boolean addComment(Comment comment);
    List<Comment> getCommentsByGid(Integer gid);
    //List<Comment> getCurrentComment(Integer gid, int currentPage, int pageSize);
}
