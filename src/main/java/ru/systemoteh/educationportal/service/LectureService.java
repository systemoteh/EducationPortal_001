package ru.systemoteh.educationportal.service;

import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public interface LectureService {

    Lecture getLectureById(Integer id);

    Lecture getLectureByNameEng(String nameEng);

    Lecture getLectureByNameRus(String nameRus);

    Lecture getLectureByLink(String link);

    List<Lecture> getAllLectures();

    List<Lecture> getLecturesByCourseId(Integer courseId);

}
