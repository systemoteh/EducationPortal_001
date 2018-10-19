package ru.systemoteh.educationportal.prim.service;

import ru.systemoteh.educationportal.prim.model.Course;

import java.util.List;

public interface CourseService {

    Course getCourseById(Integer id);

    List<Course> getAllCourses();

}
