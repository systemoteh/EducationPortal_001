package ru.systemoteh.educationportal.prim.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "edu_portal_prim", name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "lecture_id")
    private Integer lectureId;

    @Column(name = "number")
    private Integer number;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_rus")
    private String nameRus;

    @Column(name = "task")
    private String task;

    @Column(name = "solution")
    private String solution;

    // @see this.lectureId, column lecture_id
    @ManyToOne
    @JoinColumn(name = "lecture_id", nullable = false, insertable = false, updatable = false)
    private Lecture lecture;

    @Transient
    private String userSolution;

    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLectureId() {
        return lectureId;
    }

    public void setLectureId(Integer lectureId) {
        this.lectureId = lectureId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getUserSolution() {
        return userSolution;
    }

    public void setUserSolution(String userSolution) {
        this.userSolution = userSolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id) &&
                Objects.equals(lectureId, test.lectureId) &&
                Objects.equals(number, test.number) &&
                Objects.equals(typeId, test.typeId) &&
                Objects.equals(nameEng, test.nameEng) &&
                Objects.equals(nameRus, test.nameRus) &&
                Objects.equals(task, test.task) &&
                Objects.equals(solution, test.solution) &&
                Objects.equals(userSolution, test.userSolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lectureId, number, typeId, nameEng, nameRus, task, solution, userSolution);
    }
}
