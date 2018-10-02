package ru.systemoteh.educationportal.service;

import ru.systemoteh.educationportal.dao.LectureDao;
import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public class LectureServiceImpl implements LectureService {

    private LectureDao lectureDao;

    public void setLectureDao(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    @Override
    public Lecture getLectureById(Integer id) {
        return lectureDao.getLectureById(id);
    }

    @Override
    public Lecture getLectureByLink(String link) {
        return lectureDao.getLectureByLink(link);
    }

    @Override
    public Lecture getLectureByCourseIdAndLectureLink(Integer courseId, String lectureLink) {
        return lectureDao.getLectureByCourseIdAndLectureLink(courseId, lectureLink);
    }

    @Override
    public List<Lecture> getLecturesByCourseId(Integer courseId) {
        return lectureDao.getLecturesByCourseId(courseId);
    }

    @Override
    public List<Lecture> getUserLectureListByUserId(Long userId) {
        return lectureDao.getUserLectureListByUserId(userId);
    }

    @Override
    public boolean unblockLecture(Long userId, int lectureId) {
        return lectureDao.unblockLecture(userId, lectureId);
    }
}
