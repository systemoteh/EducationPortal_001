package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public interface LectureDao {

    Lecture getLectureById(Integer id);

    Lecture getLectureByLink(String link);

    Lecture getLectureByCourseIdAndLectureLink(Integer courseId, String lectureLink);

    List<Lecture> getLecturesByCourseId(Integer courseId);

    List<Lecture> getUserLectureListByUserId(Long userId);

    boolean unblockLecture(Long userId, int lectureId);

    boolean unblockLectureWithoutCoins(Long userId, int lectureId); // no used

}
