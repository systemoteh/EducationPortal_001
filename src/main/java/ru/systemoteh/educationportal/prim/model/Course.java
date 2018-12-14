package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object that represents a Course.
 */

@Entity
@Table(schema = "edu_portal_prim", name = "course")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_eng")
    private String nameEng;

    @Column(name = "name_rus")
    private String nameRus;

    @Column(name = "link")
    private String link;

    @Column(name = "description")
    private String description;

    // @see Lecture.course
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<Lecture> lectureList;

//    TODO Test what's best for performance: @OneToMany ore @Transient
//    @Transient
//    private List<Lecture> lectureList;

}
