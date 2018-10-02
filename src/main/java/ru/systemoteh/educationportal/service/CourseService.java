package ru.systemoteh.educationportal.service;

import ru.systemoteh.educationportal.model.Course;

import java.util.List;

public interface CourseService {

    Course getCourseById(Integer id);

    List<Course> getAllCourses();

}
