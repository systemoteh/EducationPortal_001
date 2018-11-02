package ru.systemoteh.educationportal.prim.service;

import ru.systemoteh.educationportal.prim.model.Lecture;

import java.util.List;

public interface LectureService {

    boolean unblockLecture(Long userId, Long lectureId);

}
