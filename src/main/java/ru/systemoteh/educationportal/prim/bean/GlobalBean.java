package ru.systemoteh.educationportal.prim.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.service.CourseService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;

@ManagedBean(name = "globalBean")
@ApplicationScoped
@Component
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GlobalBean {

    private List<Course> courseList;

    @ManagedProperty(value = "#{courseService}")
    private CourseService courseService;

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseServise(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostConstruct
    public void init() {
        courseList = courseService.getAllCourses();
        //  Each course contains a list of lectures, each lecture contains a list of tests (see Course.java, Lecture.java)
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
}
