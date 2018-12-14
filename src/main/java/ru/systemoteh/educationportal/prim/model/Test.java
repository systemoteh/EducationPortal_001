package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "edu_portal_prim", name = "test")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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

}
