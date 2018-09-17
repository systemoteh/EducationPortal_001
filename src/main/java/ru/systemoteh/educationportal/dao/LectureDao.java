package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Course;
import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public interface LectureDao {

    Lecture getLectureById(Integer id);

    Lecture getLectureByNameEng(String nameEng);

    Lecture getLectureByNameRus(String nameRus);

    Lecture getLectureByLink(String link);

    List<Lecture> getAllLectures();

    List<Lecture> getLecturesByCourseId(Integer courseId);

}
