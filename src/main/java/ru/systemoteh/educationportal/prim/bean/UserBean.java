package ru.systemoteh.educationportal.prim.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.prim.model.*;
import ru.systemoteh.educationportal.prim.service.LectureService;
import ru.systemoteh.educationportal.prim.service.TestService;
import ru.systemoteh.educationportal.prim.service.UserService;
import ru.systemoteh.educationportal.prim.util.Converter;

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
@Getter
@Setter
public class UserBean {

    private User currentUser;
    private Course selectedCourse;
    private Lecture selectedLecture;
    private UserCourse selectedUserCourse;
    private UserLecture selectedUserLecture;
    private long expToConvert = 30;

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
        return selectedUserLecture == null; // set in RootController
    }

    public void unblockLecture(ActionEvent actionEvent) {
        long newCoins = currentUser.getUserDetail().getCoins() - selectedLecture.getCost();
        if (newCoins >= 0 && lectureService.unblockLecture(currentUser.getId(), selectedLecture.getId())) {
            currentUser.getUserDetail().setCoins(newCoins);
            selectedUserLecture = Converter.convertLectureToUserLecture(currentUser.getId(), selectedLecture);  // TODO refactor to stream
            selectedUserCourse.getUserLectureList().add(selectedUserLecture);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Lecture unblocked. - " + selectedLecture.getCost() + " coins", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
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

    public void saveLectureConspectus() {
        lectureService.saveLectureConspectus(selectedLecture.getConspectus());
    }

}
