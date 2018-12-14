package ru.systemoteh.educationportal.prim.dao;

import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourses();

    UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId);

}
