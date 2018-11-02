package ru.systemoteh.educationportal.prim.dao;

import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;

import java.util.List;

public interface CourseDao {

    Course getCourseById(Long id);

    List<Course> getAllCourses();

    List<UserCourse> getUserCourseListByUserId(Long userId);

    UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId);

}
