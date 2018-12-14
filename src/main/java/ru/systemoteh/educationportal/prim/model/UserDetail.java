package ru.systemoteh.educationportal.prim.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/**
 * Simple JavaBean domain object that represents a User Detail.
 */

@Entity
@Table(schema = "edu_portal_prim", name = "user_detail")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
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
    private String email;

    @Column(name = "birth_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "coins")
    private Long coins;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "first_visit", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstVisit;

    @Column(name = "last_visit", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastVisit;

    // @see this.userId  @Column(name = "user_id")
    @OneToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;


    /**********************************************************************************************
     *  Methods
     *********************************************************************************************/

    public String getFirstVisitSting() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(firstVisit);
    }

    public String getLastVisitString() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(lastVisit);
    }


}
