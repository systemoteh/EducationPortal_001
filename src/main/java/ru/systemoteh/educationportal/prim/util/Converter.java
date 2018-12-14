package ru.systemoteh.educationportal.prim.util;

import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.Test;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static UserLecture convertLectureToUserLecture(Long userId, Lecture lecture) {
        UserLecture userLecture = new UserLecture();
        List<UserTest> userTestList = new ArrayList<>();
        userLecture.setUserId(userId);
        userLecture.setLectureId(lecture.getId());
        for (Test test : lecture.getTestList()) {
            UserTest userTest = new UserTest();
            userTest.setUserId(userId);
            userTest.setTestId(test.getId());
            userTestList.add(userTest);
        }
        userLecture.setUserTestList(userTestList);
        return userLecture;
    }

}
