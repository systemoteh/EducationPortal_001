package ru.systemoteh.educationportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.systemoteh.educationportal.bean.CourseBean;
import ru.systemoteh.educationportal.model.Course;
import ru.systemoteh.educationportal.service.CourseServise;


@Controller
public class CourseController {

    @Autowired
    private CourseBean courseBean;

    @Autowired
    private CourseServise courseServise;

    @RequestMapping(value = {"/", "/education"}, method = RequestMethod.GET)
    public String course(@RequestParam(value = "course", required = false) String link, Model model) {

        /**  CourseBean is a @Component, therefore courseBean.getCourseList() never is null
         *  @see CourseBean.init();
         */
/*        if (courseBean.getCourseList() == null) {
            courseBean.setCourseList(courseServise.getAllCourses());
        }*/

        for (Course course : courseBean.getCourseList()) {
            if (course.getLink().equals(link)) {
                courseBean.setSelectedCourse(course);
            }
        }

        return "education.xhtml";
    }

}
