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
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.service.CourseService;
import ru.systemoteh.educationportal.service.LectureService;


@Controller
public class PortalController {

    private static final String REDIRECT_TO_INDEX = "redirect:/index.xhtml";
    private static final String EDUCATION = "education.xhtml";
    private String courseLink;
    private String lectureLink;

    @Autowired
    private CourseBean courseBean;

    @Autowired
    private LectureBean lectureBean;

    @Autowired
    private CourseService courseService;    // no used

    @Autowired
    private LectureService lectureService;  // no used

    /**
     * CourseBean is a @Component, therefore courseBean.getCourseList() never is null
     *
     * @see CourseBean init();
     */


    @RequestMapping(value = {"/", "/education"}, method = RequestMethod.GET)
    public String education(@RequestParam(value = "course", required = false) String courseLink,
                            @RequestParam(value = "lecture", required = false) String lectureLink,
                            Model model) {

        this.courseLink = courseLink;
        this.lectureLink = lectureLink;
        // если ранее никакой курс не был выбран или запрашивается не текущий(ранее выбранный) курс
        if (courseBean.getSelectedCourse() == null || !courseBean.getSelectedCourse().getLink().equals(courseLink)) {
            return selectAnotherCourseAndLecture();
        } else {
            return selectAnotherLectureInSelectedCourse();
        }
    }

    private String selectAnotherCourseAndLecture() {
        Course course = courseBean.getCourseList().stream().
                filter(item -> item.getLink().equals(courseLink)).findAny().orElse(null);

        if (course != null) {
            courseBean.setSelectedCourse(course);
            selectAnotherLectureInSelectedCourse();
            return EDUCATION;
        } else {
            return REDIRECT_TO_INDEX;
        }
    }

    private String selectAnotherLectureInSelectedCourse() {
        Lecture lecture = courseBean.getSelectedCourse().getLectureList().stream()
                .filter(item -> item.getLink().equals(lectureLink)).findAny().orElse(null);

        if (lecture != null) {
            lectureBean.setSelectedLecture(lecture);
        } else {
            lectureLink = courseBean.getSelectedCourse().getLink() + "-intro";
            selectAnotherLectureInSelectedCourse();
        }
        return EDUCATION;
    }

    // TODO http://localhost:777/pages/global/education.xhtml  FAIL

}