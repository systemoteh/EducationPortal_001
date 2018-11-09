package ru.systemoteh.educationportal.prim.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.systemoteh.educationportal.prim.bean.GlobalBean;
import ru.systemoteh.educationportal.prim.bean.UserBean;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.Lecture;
import ru.systemoteh.educationportal.prim.model.UserCourse;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.service.CourseService;


@Controller
public class RootController {

    private static final String REDIRECT_TO_INDEX = "redirect:/index.xhtml";
    private static final String EDUCATION = "education.xhtml";
    private String courseLink;
    private String lectureLink;

    @Autowired
    private GlobalBean globalBean;

    @Autowired
    private UserBean userBean;

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = {"/", "/education"}, method = RequestMethod.GET)
    public String education(@RequestParam(value = "course", required = false) String courseLink,
                            @RequestParam(value = "lecture", required = false) String lectureLink,
                            Model model) {

        this.courseLink = courseLink;
        this.lectureLink = lectureLink;

        // если ранее никакой курс не был выбран или запрашивается не текущий(ранее выбранный) курс
        if (userBean.getSelectedCourse() == null || !userBean.getSelectedCourse().getLink().equals(courseLink)) {
            return selectAnotherCourseAndLecture();
        } else {
            return selectAnotherLectureInSelectedCourse();
        }
    }

    private String selectAnotherCourseAndLecture() {
        Course course = globalBean.getCourseList().stream().
                filter(item -> item.getLink().equals(courseLink)).findAny().orElse(null);
        if (course != null) {
            userBean.setSelectedCourse(course);
            UserCourse userCourse = courseService.getUserCourseByUserIdAndCourseId(
                    userBean.getCurrentUser().getId(), course.getId());
            userBean.setSelectedUserCourse(userCourse);
            selectAnotherLectureInSelectedCourse();
            return EDUCATION;
        } else {
            return REDIRECT_TO_INDEX;
        }
    }

    private String selectAnotherLectureInSelectedCourse() {
        Lecture lecture = userBean.getSelectedCourse().getLectureList().stream()
                .filter(item -> item.getLink().equals(lectureLink))
                .findAny().orElse(null);
        if (lecture != null) {
            userBean.setSelectedLecture(lecture);
            UserLecture userLecture = userBean.getSelectedUserCourse().getUserLectureList().stream()
                    .filter(item -> item.getLectureId().equals(lecture.getId()))
                    .findAny().orElse(null);
            userBean.setSelectedUserLecture(userLecture);
        } else {
            lectureLink = userBean.getSelectedCourse().getLink() + "-intro";
            selectAnotherLectureInSelectedCourse();
        }
        return EDUCATION;
    }


    // TODO Заглушка(чтобы не было лога об ошибки "не найден маппинг на /favicon.ico"), разобраться для чего /favicon.ico
    @RequestMapping(value = {"/favicon.ico"}, method = RequestMethod.GET)
    public String favicon(Model model) {
        return REDIRECT_TO_INDEX;
    }


//        TODO http://localhost:777/pages/global/education.xhtml  FAIL

//        TODO: если пользователь был на какой-то странице и у него закончилось время сесии,
//        TODO то после авторизации он будет переброшен на последнюю страницу (Spring Security)
//        TODO  и у него не будет заполнен ни курс, ни лекция
//        if (userBean.getSelectedCourse() == null) {
//          userBean.setSelectedCourse(last visit course (from Cookie));
//        }
//        if (selectedLecture == null) {
//          selectedLecture = last visit lecture (from Cookie)
//        } сейчас если лекция == null, то подгружается intro лекция

}