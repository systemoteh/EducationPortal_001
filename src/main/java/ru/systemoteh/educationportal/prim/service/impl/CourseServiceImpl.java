package ru.systemoteh.educationportal.prim.service.impl;

import org.springframework.stereotype.Service;
import ru.systemoteh.educationportal.prim.dao.CourseDao;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;
import ru.systemoteh.educationportal.prim.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }


    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId) {
        return courseDao.getUserCourseByUserIdAndCourseId(userId, courseId);
    }
}
