package ru.systemoteh.educationportal.service;

import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public interface LectureService {

    Lecture getLectureById(Integer id);

    Lecture getLectureByLink(String link);

    Lecture getLectureByCourseIdAndLectureLink(Integer courseId, String lectureLink);

    List<Lecture> getLecturesByCourseId(Integer courseId);

    List<Lecture> getUserLectureListByUserId(Long userId);

    boolean unblockLecture(Long userId, int lectureId);

}
