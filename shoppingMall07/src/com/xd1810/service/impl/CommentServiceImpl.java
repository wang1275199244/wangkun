package com.xd1810.service.impl;

import com.xd1810.dao.CommentDao;
import com.xd1810.model.Comment;
import com.xd1810.model.Good;
import com.xd1810.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    @Override
    public boolean addComment(Comment comment) {
        if(comment == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getCommentsByGid(Integer gid) {
        if(gid == null){
            throw new IllegalArgumentException("入参不合法");
        }
        return commentDao.getCommentsByGid(gid);
    }

  /*  @Override
    public List<Comment> getCurrentComment(Integer gid, int currentPage, int pageSize) {
        return commentDao.getCurrentComment(gid,currentPage,pageSize);
    }*/
}
