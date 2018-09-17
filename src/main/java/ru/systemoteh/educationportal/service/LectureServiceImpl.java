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
        // TODO
        return null;
    }

    @Override
    public Lecture getLectureByNameEng(String nameEng) {
        // TODO
        return null;
    }

    @Override
    public Lecture getLectureByNameRus(String nameRus) {
        // TODO
        return null;
    }

    @Override
    public Lecture getLectureByLink(String link) {
        // TODO
        return null;
    }

    @Override
    public List<Lecture> getAllLectures() {
        // TODO
        return null;
    }

    @Override
    public List<Lecture> getLecturesByCourseId(Integer courseId) {
        return lectureDao.getLecturesByCourseId(courseId);
    }
}
