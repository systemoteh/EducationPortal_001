package ru.systemoteh.educationportal.service;

import org.springframework.stereotype.Service;
import ru.systemoteh.educationportal.dao.CourseDao;
import ru.systemoteh.educationportal.model.Course;

import java.util.List;

@Service
public class CourseServiseImpl implements CourseServise {

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public Course getCourseByNameEng(String nameEng) {
        return courseDao.getCourseByNameEng(nameEng);
    }

    @Override
    public Course getCourseByNameRus(String nameRus) {
        return courseDao.getCourseByNameRus(nameRus);
    }

    @Override
    public Course getCourseByLink(String link) {
        return courseDao.getCourseByLink(link);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

}
