package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(schema = "edu_portal_prim", name = "test")
//@NoArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "order_by")
    private Long orderBy;

    @Column(name = "type_id")
    private Long typeId;

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

    public Test() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return Objects.equals(id, test.id) &&
                Objects.equals(lectureId, test.lectureId) &&
                Objects.equals(orderBy, test.orderBy) &&
                Objects.equals(typeId, test.typeId) &&
                Objects.equals(nameEng, test.nameEng) &&
                Objects.equals(nameRus, test.nameRus) &&
                Objects.equals(task, test.task) &&
                Objects.equals(solution, test.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lectureId, orderBy, typeId, nameEng, nameRus, task, solution);
    }
}
