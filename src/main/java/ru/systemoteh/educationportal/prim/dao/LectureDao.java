package ru.systemoteh.educationportal.prim.dao;

import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import java.util.List;

public interface LectureDao {

    List<UserLecture> getUserLectureListByUserId(Long userId);

    List<UserTest> getUserTestListByUserId(Long userId);

    boolean unblockLecture(Long userId, Long lectureId);

}
