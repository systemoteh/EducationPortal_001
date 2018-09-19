package ru.systemoteh.educationportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.systemoteh.educationportal.bean.CourseBean;
import ru.systemoteh.educationportal.bean.LectureBean;
import ru.systemoteh.educationportal.model.Course;
import ru.systemoteh.educationportal.service.CourseServise;
import ru.systemoteh.educationportal.service.LectureService;


@Controller
public class PortalController {

    @Autowired
    private CourseBean courseBean;

    @Autowired
    private LectureBean lectureBean;

    @Autowired
    private CourseServise courseServise;

    @Autowired
    private LectureService lectureService;

    @RequestMapping(value = {"/", "/education"}, method = RequestMethod.GET)
    public String education(@RequestParam(value = "course", required = false) String courseLink,
                         @RequestParam(value = "lecture", required = false) String lectureLink,
                         Model model) {

        /**  CourseBean is a @Component, therefore courseBean.getCourseList() never is null
         *  @see CourseBean.init();
         */
/*        if (courseBean.getCourseList() == null) {
            courseBean.setCourseList(courseServise.getAllCourses());
        }*/

        // TODO if courseLink == null, if lectureLink == null;

        // TODO if courseBean.getSelectedCourse == null
//        for (Course course : courseBean.getCourseList()) {
//            if (course.getLink().equals(courseLink)) {
//                courseBean.setSelectedCourse(course);
//            }
//        }

        // TODO if lectureBean.getSelectedLecture == null REFACTOR
//        if (lectureLink != null ||  !lectureLink.isEmpty()) {
//            lectureBean.setSelectedLecture(lectureService.getLectureByLink(lectureLink));
//        }


        return "education.xhtml";
    }

}
