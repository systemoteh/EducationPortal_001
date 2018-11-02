package ru.systemoteh.educationportal.prim.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user___course", schema = "edu_portal_prim")
public class UserCourse implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "course_id")
    private Long courseId;

    @Basic
    @Column(name = "certificate")
    private byte[] certificate;

    @Transient
    private List<UserLecture> userLectureList;

    public UserCourse() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    public List<UserLecture> getUserLectureList() {
        return userLectureList;
    }

    public void setUserLectureList(List<UserLecture> userLectureList) {
        this.userLectureList = userLectureList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCourse)) return false;
        UserCourse that = (UserCourse) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }
}
