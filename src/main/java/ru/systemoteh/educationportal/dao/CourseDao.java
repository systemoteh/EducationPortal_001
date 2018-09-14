package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Course;

import java.util.List;

public interface CourseDao {

    Course getCourseById(Integer id);

    Course getCourseByNameEng(String nameEng);

    Course getCourseByNameRus(String nameRus);

    Course getCourseByLink(String link);

    List<Course> getAllCourses();

}
