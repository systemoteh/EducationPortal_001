package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public interface LectureDao {

    boolean unblockLecture(Long userId, int lectureId);

}
