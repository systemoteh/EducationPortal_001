package ru.systemoteh.educationportal.service.impl;

import org.springframework.stereotype.Service;
import ru.systemoteh.educationportal.dao.CourseDao;
import ru.systemoteh.educationportal.model.Course;
import ru.systemoteh.educationportal.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Course getCourseById(Integer id) {
        return courseDao.getCourseById(id);
    }


    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

}
