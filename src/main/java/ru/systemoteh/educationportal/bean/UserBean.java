package ru.systemoteh.educationportal.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.model.User;
import ru.systemoteh.educationportal.service.security.UserSecurityService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
 * Если не указать данный параметр, Компонент (Бин) будет работать как Синглтон. У всех пользователей будет один и тот же компонент (бин)
 */

@ManagedBean(name = "userBean")
@SessionScoped
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
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
