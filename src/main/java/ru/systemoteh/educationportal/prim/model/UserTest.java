package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "user___test", schema = "edu_portal_prim")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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

}
