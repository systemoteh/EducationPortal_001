package ru.systemoteh.educationportal.prim.dao;

import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.Test;

import java.util.List;

public interface LectureDao {

    List<Lecture> getUserLectureListByUserId(Long userId);

    List<Test> getUserTestListByUserId(Long userId);

    boolean unblockLecture(Long userId, int lectureId);

}
