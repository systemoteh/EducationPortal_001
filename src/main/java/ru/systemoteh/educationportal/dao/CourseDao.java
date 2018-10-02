package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Course;

import java.util.List;

public interface CourseDao {

    Course getCourseById(Integer id);

    List<Course> getAllCourses();

}
