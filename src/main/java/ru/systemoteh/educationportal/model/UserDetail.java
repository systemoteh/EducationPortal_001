package ru.systemoteh.educationportal.model;

import ru.systemoteh.educationportal.dao.UserDaoImpl;

import javax.persistence.*;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a User Detail.
 */

@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firsName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "coins")
    private Long coins;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)    // @see this.userId  @Column(name = "user_id")
    private User user;

    public UserDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Long getCoins() {
        return coins;
    }

    public void setCoins(Long coins) {
        this.coins = coins;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetail)) return false;
        UserDetail that = (UserDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(firsName, that.firsName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(eMail, that.eMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, firsName, lastName, eMail);
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", userId=" + userId +
                ", firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", coins=" + coins +
                ", experience=" + experience +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
