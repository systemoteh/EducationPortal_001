package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user___lecture", schema = "edu_portal_prim")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserLecture implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "status_id")
    private Long statusId;

    @Basic
    @Column(name = "rating")
    private Long rating;

    @Transient
    private List<UserTest> userTestList = new ArrayList<>();

}
