package ru.systemoteh.educationportal.prim.dao;

public interface LectureDao {

    boolean unblockLecture(Long userId, Long lectureId);

    void saveLectureConspectus(String lectureConspectus);

}
