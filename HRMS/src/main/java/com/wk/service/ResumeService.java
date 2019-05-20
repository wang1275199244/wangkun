package com.wk.service;

import com.wk.model.Resume;

import java.util.List;

public interface ResumeService {
    boolean addResume(Resume resume);
    boolean delResume(Resume resume);
    boolean updateResume(Resume resume);
    Resume getResumeById(Integer id);
    List<Resume> getResumeByVid(Integer vid);
}
