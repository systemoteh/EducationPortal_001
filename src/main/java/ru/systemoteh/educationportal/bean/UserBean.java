package ru.systemoteh.educationportal.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.model.User;
import ru.systemoteh.educationportal.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private long expToConvert;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @ManagedProperty(value = "#{courseBean}")
    CourseBean courseBean;

    @Autowired(required = true)
    @Qualifier(value = "courseBean")
    public void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    @PostConstruct
    public void init() {

    }

    public void saveUserDetail() {
        if (userService.saveUserDetail(currentUser.getUserDetail())) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "UserDetail SAVE", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "UserDetail NOT SAVE. " +
                    "E-Mail NOT UNIQUE", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void convertExpToCoins() {
        long newCoins = 10 * expToConvert + currentUser.getUserDetail().getCoins();
        long newExperience = currentUser.getUserDetail().getExperience() - expToConvert;
        if (currentUser.getUserDetail().getExperience() >= expToConvert && expToConvert > 0 &&
                userService.convertExpToCoins(currentUser.getUserDetail().getUserId(), newCoins, newExperience)) {
            currentUser.getUserDetail().setExperience(newExperience);
            currentUser.getUserDetail().setCoins(newCoins);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Exp: -" + expToConvert + ". Coins: +" + (expToConvert * 10), null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "You don't have enough experience points", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
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

    public long getExpToConvert() {
        return expToConvert;
    }

    public void setExpToConvert(long expToConvert) {
        this.expToConvert = expToConvert;
    }
}
