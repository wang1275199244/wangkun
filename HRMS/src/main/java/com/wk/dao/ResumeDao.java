package com.wk.dao;

import com.wk.model.Resume;

import java.util.List;

public interface ResumeDao {
    int addResume(Resume resume);
    int delResume(Resume resume);
    int updateResume(Resume resume);
    Resume getResumeById(Integer id);
    List<Resume> getResumeByVid(Integer vid);

}
