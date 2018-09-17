package ru.systemoteh.educationportal.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.controller.CourseController;
import ru.systemoteh.educationportal.model.Course;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.service.CourseServise;
import ru.systemoteh.educationportal.service.LectureService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "courseBean")
@SessionScoped
@Component
public class CourseBean implements Serializable {

    private List<Course> courseList;
    private Course selectedCourse;

    @ManagedProperty(value = "#{courseServise}")
    private CourseServise courseServise;

    @Autowired(required = true)
    @Qualifier(value = "courseServise")
    public void setCourseServise(CourseServise courseServise) {
        this.courseServise = courseServise;
    }

    @ManagedProperty(value = "#{lectureService}")
    private LectureService lectureService;

    @Autowired(required = true)
    @Qualifier(value = "lectureService")
    public void setLectureService(LectureService lectureService) {
        this.lectureService = lectureService;
    }


    @PostConstruct
    public void init() {
        courseList = courseServise.getAllCourses();
    }

    /**
     * Call only from xhtml/jsp pages, because response.sendRedirect()
     *
     * @param course
     */
    public void goToCourse(Course course) {
        this.selectedCourse = course;
        // TODO Сделать LectureBean, в нем переменная selectedLecture. В Aside курса - список леций.
        // TODO Навигация по лекциям внутри курса. Начальная и конечная страницы каждого курса (однотипные названия для всех курсов)
        // TODO Первая страница курса всегда открыта для пользователя, на остальные потом сделать проверку доступа (покупка доступа за виртуальную валюту)
//        List<Lecture> lectureList = lectureService.getLecturesByCourseId(course.getId());
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            response.sendRedirect("/education?course=" + selectedCourse.getLink());
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