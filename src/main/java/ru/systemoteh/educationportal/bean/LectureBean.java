package ru.systemoteh.educationportal.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.service.LectureService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            response.sendRedirect("/education?course="
                    + courseBean.getSelectedCourse().getLink()  // TODO if courseBean.getSelectedCourse() == null
                    + "&lecture=" + selectedLecture.getLink());
        } catch (IOException e) {
            e.printStackTrace();
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
