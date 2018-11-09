package ru.systemoteh.educationportal.prim.service;

import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.UserLecture;

import java.util.List;

public interface LectureService {

    boolean unblockLecture(Long userId, Long lectureId);

    UserLecture getUserLectureByUserIdAndLectureId(Long userId, Long lectureId);

}
