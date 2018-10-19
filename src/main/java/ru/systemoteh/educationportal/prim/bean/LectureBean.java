package ru.systemoteh.educationportal.prim.bean;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.serv.model.Employee;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.serv.service.EmployeeService;
import ru.systemoteh.educationportal.prim.service.LectureService;
import ru.systemoteh.educationportal.prim.service.UserService;

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
import java.util.List;

@ManagedBean(name = "lectureBean")
@SessionScoped
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
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

    @ManagedProperty(value = "#{employeeService}")
    private EmployeeService employeeService;

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

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
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
        if (lecture != null) {
            this.selectedLecture = lecture;
        }
//        TODO: если пользователь был на какой-то странице и у него закончилось время сесии,
//        TODO то после авторизации он будет переброшен на последнюю страницу (Spring Security)
//        TODO  и у него не будет заполнен ни курс, ни лекция
//        if (courseBean.getSelectedCourse() == null) {
//          courseBean.setSelectedCourse(last visit course (from Cookie));
//        } сейчас проверна на null есть ниже
//        if (selectedLecture == null) {
//          selectedLecture = last visit lecture (from Cookie)
//        } сейчас если лекция == null, то подгружается intro лекция

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            if (courseBean.getSelectedCourse() != null) {
                response.sendRedirect("/education"
                        + "?course=" + courseBean.getSelectedCourse().getLink()
                        + "&lecture=" + selectedLecture.getLink()
                );
            } else {
                response.sendRedirect("/index"
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO Refactor this. Call from page many times. Call == lecture count
    public boolean isBlockLecture() {
        return !userBean.getCurrentUser().getUserLectureList().contains(selectedLecture);
    }

    public void unblockLecture(ActionEvent actionEvent) {
        if (userBean.getCurrentUser().getUserDetail().getCoins() >= selectedLecture.getCost()
                && lectureService.unblockLecture(userBean.getCurrentUser().getId(), selectedLecture.getId())) {  // CALL StoredProcedure with OUT boolean param
            userBean.getCurrentUser().getUserDetail().setCoins(
                    userBean.getCurrentUser().getUserDetail().getCoins() - selectedLecture.getCost()); // local update TODO Refactor return OUT params from StoredProcedure
            userBean.getCurrentUser().getUserLectureList().add(selectedLecture);    // local update TODO Refactor return OUT params from StoredProcedure
            RequestContext.getCurrentInstance().execute("PF('blockContent').hide()");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Lecture unblocked. - " + selectedLecture.getCost() + " coins", null);
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
