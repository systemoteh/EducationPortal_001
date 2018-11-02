package ru.systemoteh.educationportal.prim.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user___lecture", schema = "edu_portal_prim")
public class UserLecture implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "lecture_id")
    private Long lectureId;

    @Basic
    @Column(name = "rating")
    private Long rating;

    @Transient
    private List<UserTest> userTestList;


    public UserLecture() {
    }

    public UserLecture(Long userId, Long lectureId) {
        this.userId = userId;
        this.lectureId = lectureId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public List<UserTest> getUserTestList() {
        return userTestList;
    }

    public void setUserTestList(List<UserTest> userTestList) {
        this.userTestList = userTestList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserLecture)) return false;
        UserLecture that = (UserLecture) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(lectureId, that.lectureId) &&
                Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, lectureId, rating);
    }
}
