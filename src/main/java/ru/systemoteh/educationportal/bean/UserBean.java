package ru.systemoteh.educationportal.bean;

import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.model.User;
import ru.systemoteh.educationportal.service.security.UserSecurityService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Map;

@ManagedBean(name = "userBean")
@SessionScoped
@Component
public class UserBean {

    private User currentUser;

    @ManagedProperty(value = "#{userService}")
    private UserSecurityService userSecurityService;

    @PostConstruct
    public void init() {

    }


    /**********************************************************************************************
     *  Getters and Setters
     *********************************************************************************************/

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
