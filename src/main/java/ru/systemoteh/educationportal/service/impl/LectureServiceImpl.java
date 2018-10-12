package ru.systemoteh.educationportal.service.impl;

import ru.systemoteh.educationportal.dao.LectureDao;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.service.LectureService;

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
