package ru.systemoteh.educationportal.prim.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user___test", schema = "edu_portal_prim")
public class UserTest implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "test_id")
    private Integer testId;

    @Basic
    @Column(name = "user_solution")
    private String userSolution;

    @Basic
    @Column(name = "date_solution")
    private Timestamp dateSolution;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTest userTest = (UserTest) o;
        return Objects.equals(id, userTest.id) &&
                Objects.equals(userId, userTest.userId) &&
                Objects.equals(testId, userTest.testId) &&
                Objects.equals(userSolution, userTest.userSolution) &&
                Objects.equals(dateSolution, userTest.dateSolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, testId, userSolution, dateSolution);
    }
}
