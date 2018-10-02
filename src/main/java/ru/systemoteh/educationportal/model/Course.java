package ru.systemoteh.educationportal.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a Course.
 */

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_rus")
    private String nameRus;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    @Transient
    private List<Lecture> lectureList;

    public Course() {
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

    public List<Lecture> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lecture> lectureList) {
        this.lectureList = lectureList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id) &&
                Objects.equals(nameEng, course.nameEng) &&
                Objects.equals(nameRus, course.nameRus) &&
                Objects.equals(link, course.link) &&
                Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameEng, nameRus, link, description);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", nameEng='" + nameEng + '\'' +
                ", nameRus='" + nameRus + '\'' +
                ", link='" + link + '\'' +
                ", description='" + description +
                '}';
    }
}
