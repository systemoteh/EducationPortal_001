package ru.systemoteh.educationportal.prim.service;

import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;

import java.util.List;

public interface CourseService {

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    List<UserCourse> getUserCourseListByUserId(Long userId);

    UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId);

}
