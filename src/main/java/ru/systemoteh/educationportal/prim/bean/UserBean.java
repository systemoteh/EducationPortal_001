package ru.systemoteh.educationportal.prim.bean;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.prim.model.*;
import ru.systemoteh.educationportal.prim.service.LectureService;
import ru.systemoteh.educationportal.prim.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
 * Если не указать данный параметр, Компонент (Bean) будет работать как Синглтон. У всех пользователей будет один и тот же компонент (Bean)
 */

@ManagedBean(name = "userBean")
@SessionScoped
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserBean {

    private User currentUser;
    private Course selectedCourse;
    private Lecture selectedLecture;
    private UserCourse selectedUserCourse;
    private UserLecture selectedUserLecture;
    private long expToConvert;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @ManagedProperty(value = "#{lectureService}")
    private LectureService lectureService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired(required = true)
    @Qualifier(value = "lectureService")
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @PostConstruct
    public void init() {

    }

    public boolean isBlockLecture() {
        return selectedUserLecture == null;
    }

    public void unblockLecture(ActionEvent actionEvent) {
        if (currentUser.getUserDetail().getCoins() >= selectedLecture.getCost()
                && lectureService.unblockLecture(currentUser.getId(), selectedLecture.getId())) {
            currentUser.getUserDetail().setCoins(
                    currentUser.getUserDetail().getCoins() - selectedLecture.getCost());
            selectedUserCourse.getUserLectureList().add(
                    selectedUserLecture = new UserLecture(currentUser.getId(), selectedLecture.getId()));
//            RequestContext.getCurrentInstance().execute("PF('blockContent').hide()");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Lecture unblocked. - " + selectedLecture.getCost() + " coins", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
//            RequestContext.getCurrentInstance().execute("PF(':blockForm:blockContent').show()");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Lecture NOT unblocked. You don't have enough coins", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
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

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public Lecture getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(Lecture selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

    public UserCourse getSelectedUserCourse() {
        return selectedUserCourse;
    }

    public void setSelectedUserCourse(UserCourse selectedUserCourse) {
        this.selectedUserCourse = selectedUserCourse;
    }

    public UserLecture getSelectedUserLecture() {
        return selectedUserLecture;
    }

    public void setSelectedUserLecture(UserLecture selectedUserLecture) {
        this.selectedUserLecture = selectedUserLecture;
    }

    public long getExpToConvert() {
        return expToConvert;
    }

    public void setExpToConvert(long expToConvert) {
        this.expToConvert = expToConvert;
    }


}
