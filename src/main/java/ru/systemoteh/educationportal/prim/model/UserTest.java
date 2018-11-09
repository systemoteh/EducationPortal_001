package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user___test", schema = "edu_portal_prim")
//@NoArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
public class UserTest implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "test_id")
    private Long testId;

    @Basic
    @Column(name = "user_solution")
    private String userSolution;

    @Basic
    @Column(name = "date_solution")
    private Timestamp dateSolution;

    @Basic
    @Column(name = "status_id")
    private Long statusId;

    @Transient
    private UserLecture userLecture;

    public UserTest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getUserSolution() {
        return userSolution;
    }

    public void setUserSolution(String userSolution) {
        this.userSolution = userSolution;
    }

    public Timestamp getDateSolution() {
        return dateSolution;
    }

    public void setDateSolution(Timestamp dateSolution) {
        this.dateSolution = dateSolution;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }


    public UserLecture getUserLecture() {
        return userLecture;
    }

    public void setUserLecture(UserLecture userLecture) {
        this.userLecture = userLecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserTest)) return false;
        UserTest userTest = (UserTest) o;
        return Objects.equals(userId, userTest.userId) &&
                Objects.equals(testId, userTest.testId) &&
                Objects.equals(userSolution, userTest.userSolution) &&
                Objects.equals(statusId, userTest.statusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash( userId, testId, userSolution, statusId);
    }
}
