package ru.systemoteh.educationportal.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a Lecture.
 */

@Entity
@Table(name = "lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_rus")
    private String nameRus;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)    // @see this.courseId, column course_id
    private Course course;

    public Lecture() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lecture)) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(id, lecture.id) &&
                Objects.equals(nameEng, lecture.nameEng) &&
                Objects.equals(nameRus, lecture.nameRus) &&
                Objects.equals(courseId, lecture.courseId) &&
                Objects.equals(link, lecture.link) &&
                Objects.equals(description, lecture.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameEng, nameRus, courseId, link, description);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", nameEng='" + nameEng + '\'' +
                ", nameRus='" + nameRus + '\'' +
                ", courseId=" + courseId +
                ", link='" + link + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
