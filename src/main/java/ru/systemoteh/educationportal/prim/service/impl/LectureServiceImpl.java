package ru.systemoteh.educationportal.prim.service.impl;

import ru.systemoteh.educationportal.prim.dao.LectureDao;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.service.LectureService;

import java.util.List;

public class LectureServiceImpl implements LectureService {

    private LectureDao lectureDao;

    public void setLectureDao(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    @Override
    public boolean unblockLecture(Long userId, int lectureId) {
        return lectureDao.unblockLecture(userId, lectureId);
    }
}