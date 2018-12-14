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
@Table(name = "user___course", schema = "edu_portal_prim")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserCourse implements Serializable {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Id
    @Column(name = "course_id")
    private Long courseId;

    @Basic
    @Column(name = "certificate")
    private byte[] certificate;

    @Transient
    private List<UserLecture> userLectureList = new ArrayList<>();

}
