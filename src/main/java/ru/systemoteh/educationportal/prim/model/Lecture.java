package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a Lecture.
 */

@Entity
@Table(schema = "edu_portal_prim", name = "lecture")
//@NoArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_rus")
    private String nameRus;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "order_by")
    private Long orderBy;

    @Column(name = "test_type_id")
    private Long testTypeId;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    // @see this.courseId, column course_id
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
    private Course course;

    // @see Test.lecture
    @OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
    private List<Test> testList;

    public Lecture() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Long orderBy) {
        this.orderBy = orderBy;
    }

    public Long getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(Long testTypeId) {
        this.testTypeId = testTypeId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lecture)) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(id, lecture.id) &&
                Objects.equals(nameEng, lecture.nameEng) &&
                Objects.equals(nameRus, lecture.nameRus) &&
                Objects.equals(courseId, lecture.courseId) &&
                Objects.equals(orderBy, lecture.orderBy) &&
                Objects.equals(testTypeId, lecture.testTypeId) &&
                Objects.equals(cost, lecture.cost) &&
                Objects.equals(link, lecture.link) &&
                Objects.equals(description, lecture.description) &&
                Objects.equals(course, lecture.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameEng, nameRus, courseId, orderBy, testTypeId, cost, link, description, course);
    }
}
