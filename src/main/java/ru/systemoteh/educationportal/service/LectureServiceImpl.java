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
    public Lecture getLectureByNameEng(String nameEng) {
        return lectureDao.getLectureByNameEng(nameEng);
    }

    @Override
    public Lecture getLectureByNameRus(String nameRus) {
        return lectureDao.getLectureByNameRus(nameRus);
    }

    @Override
    public Lecture getLectureByLink(String link) {
        return lectureDao.getLectureByLink(link);
    }

    @Override
    public List<Lecture> getAllLectures() {
        return lectureDao.getAllLectures();
    }

    @Override
    public List<Lecture> getLecturesByCourseId(Integer courseId) {
        return lectureDao.getLecturesByCourseId(courseId);
    }
}
