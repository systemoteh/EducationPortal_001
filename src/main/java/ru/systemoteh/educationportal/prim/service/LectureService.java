package ru.systemoteh.educationportal.prim.service;

public interface LectureService {

    boolean unblockLecture(Long userId, Long lectureId);

    void saveLectureConspectus(String lectureConspectus);

}
