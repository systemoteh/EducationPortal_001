package ru.systemoteh.educationportal.prim.dao;

import ru.systemoteh.educationportal.prim.model.Course;

import java.util.List;

public interface CourseDao {

    Course getCourseById(Integer id);

    List<Course> getAllCourses();

}
