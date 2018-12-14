package ru.systemoteh.educationportal.prim.service;

import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId);

}
