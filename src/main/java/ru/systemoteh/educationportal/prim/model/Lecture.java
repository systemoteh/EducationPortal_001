package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Simple JavaBean domain object that represents a Lecture.
 */

@Entity
@Table(schema = "edu_portal_prim", name = "lecture")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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

    @Column(name = "conspectus")
    private String conspectus;

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

}
