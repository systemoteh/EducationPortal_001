package ru.systemoteh.educationportal.bean;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.service.LectureService;
import ru.systemoteh.educationportal.service.UserService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@ManagedBean(name = "lectureBean")
@SessionScoped
@Component
public class LectureBean implements Serializable {

    private Lecture selectedLecture;

    @ManagedProperty(value = "#{courseBean}")
    CourseBean courseBean;

    @ManagedProperty(value = "#{lectureService}")
    private LectureService lectureService;

    @ManagedProperty(value = "#{userBean}")
    UserBean userBean;

    @ManagedProperty(value = "#{userService}")
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "lectureService")
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @Autowired(required = true)
    @Qualifier(value = "courseBean")
    public void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    @Autowired(required = true)
    @Qualifier(value = "userBean")
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void init() {
        // TODO get from Cookie selectedLecture.link
        // TODO if (selectedLecture.link from Cookie contains selectedCourse.link) selectedLecture = lectureService.getLectureByLink(selectedLecture.link from Cookie);
    }

    /**
     * Call only from xhtml/jsp pages, because response.sendRedirect()
     *
     * @param lecture
     */
    public void goToLecture(Lecture lecture) {
        this.selectedLecture = lecture;
//        if (selectedLecture == null) {
//            selectedLecture = lectureService.getLectureByLink(courseBean.getSelectedCourse().getLink() + "-intro");
//        }

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            response.sendRedirect("/education"
                    + "?course=" + courseBean.getSelectedCourse().getLink()
                    + "&lecture=" + selectedLecture.getLink()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isBlockLecture() {    // TODO Refactor this. Call from page many times
        return !userBean.getCurrentUser().getUserLectureList().contains(selectedLecture);
    }

    public void unblockLecture(ActionEvent actionEvent) {
        long coins = userBean.getCurrentUser().getUserDetail().getCoins();
        if (coins >= 20 && lectureService.unblockLecture(
                userBean.getCurrentUser().getId(), selectedLecture.getId())) {  // CALL StoredProcedure with OUT boolean param
            userBean.getCurrentUser().getUserDetail().setCoins(coins - 20); // local update TODO Refactor return OUT params from StoredProcedure
            userBean.getCurrentUser().getUserLectureList().add(selectedLecture);    // local update TODO Refactor return OUT params from StoredProcedure
            RequestContext.getCurrentInstance().execute("PF('blockContent').hide()");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Lecture unblocked. -20 coins", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            RequestContext.getCurrentInstance().execute("PF(':blockForm:blockContent').show()");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    "Lecture NOT unblocked. You don't have enough coins", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    /**********************************************************************************************
     *  Getters and Setters
     *********************************************************************************************/

    public Lecture getSelectedLecture() {
        return selectedLecture;
    }

    public void setSelectedLecture(Lecture selectedLecture) {
        this.selectedLecture = selectedLecture;
    }

}
