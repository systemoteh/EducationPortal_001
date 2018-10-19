package ru.systemoteh.educationportal.prim.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.service.CourseService;
import ru.systemoteh.educationportal.prim.service.LectureService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "courseBean")
@SessionScoped
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CourseBean implements Serializable {

    private List<Course> courseList;
    private Course selectedCourse;

    @ManagedProperty(value = "#{lectureBean}")
    LectureBean lectureBean;

    @ManagedProperty(value = "#{courseService}")
    private CourseService courseService;

    @ManagedProperty(value = "#{lectureService}")
    private LectureService lectureService;


    @Autowired(required = true)
    @Qualifier(value = "lectureBean")
    public void setLectureBean(LectureBean lectureBean) {
        this.lectureBean = lectureBean;
    }

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseServise(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired(required = true)
    @Qualifier(value = "lectureService")
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @PostConstruct
    public void init() {
        courseList = courseService.getAllCourses();
    }

    /**
     * Call only from xhtml/jsp pages, because response.sendRedirect()
     *
     * @param course
     */
    public void goToCourse(Course course) {
        this.selectedCourse = course;

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            response.sendRedirect("/education"
                            + "?course=" + selectedCourse.getLink()
                    // TODO last visit lecture link
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**********************************************************************************************
     *  Getters and Setters
     *********************************************************************************************/

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

}