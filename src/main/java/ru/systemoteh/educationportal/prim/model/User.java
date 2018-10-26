package ru.systemoteh.educationportal.prim.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 */

@Entity
@Table(schema = "edu_portal_prim", name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @ManyToMany
    @JoinTable(name = "user___role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToOne(mappedBy = "user")    // @see UserDetail.user
    private UserDetail userDetail;

    //    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "user___lecture", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    @Transient
    private List<Lecture> userLectureList;

    //    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "user___test", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "test_id"))
    @Transient
    private List<Test> userTestList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Lecture> getUserLectureList() {
        return userLectureList;
    }

    public void setUserLectureList(List<Lecture> userLectureList) {
        this.userLectureList = userLectureList;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Test> getUserTestList() {
        return userTestList;
    }

    public void setUserTestList(List<Test> userTestList) {
        this.userTestList = userTestList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
