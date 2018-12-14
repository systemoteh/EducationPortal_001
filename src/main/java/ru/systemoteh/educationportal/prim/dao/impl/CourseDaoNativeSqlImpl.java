package ru.systemoteh.educationportal.prim.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.systemoteh.educationportal.prim.dao.CourseDao;
import ru.systemoteh.educationportal.prim.model.Course;
import ru.systemoteh.educationportal.prim.model.UserCourse;
import ru.systemoteh.educationportal.prim.model.UserLecture;
import ru.systemoteh.educationportal.prim.model.UserTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CourseDaoNativeSqlImpl implements CourseDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDaoNativeSqlImpl.class);

    DataSource dataSource;
    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("from Course ").getResultList();
    }

    @Override
    public UserCourse getUserCourseByUserIdAndCourseId(Long userId, Long courseId) {
        Long prevLectureId = Long.MIN_VALUE;
        UserCourse userCourse = null;
        UserLecture userLecture = null;
        UserTest userTest = null;

        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT " +
                            "ut.test_id       AS ut_id, " +
                            "ut.user_solution AS ut_user_solution, " +
                            "ut.date_solution AS ut_date_solution, " +
                            "ut.status_id     AS ut_status_id, " +
                            "ul.lecture_id    AS ul_id, " +
                            "ul.status_id     AS ul_status_id, " +
                            "ul.rating        AS ul_rating " +
                            "FROM user___course uc " +
                            "INNER JOIN lecture l ON uc.course_id = l.course_id " +
                            "INNER JOIN user___lecture ul ON l.id = ul.lecture_id " +
                            "INNER JOIN test t ON l.id = t.lecture_id " +
                            "INNER JOIN user___test ut ON t.id = ut.test_id " +
                            "WHERE uc.user_id = ? " +
                            "AND ul.user_id = ? " +
                            "AND ut.user_id = ? " +
                            "AND uc.course_id = ? " +
                            "ORDER BY l.order_by, t.order_by ")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.setLong(2, userId);
                preparedStatement.setLong(3, userId);
                preparedStatement.setLong(4, courseId);
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getResultSet();
                if (!resultSet.wasNull()) {
                    userCourse = new UserCourse();
                    userCourse.setUserId(userId);
                    userCourse.setCourseId(courseId);
                }
                while (resultSet.next()) {
                    userTest = new UserTest();
                    userTest.setUserId(userId);
                    userTest.setTestId(resultSet.getLong("ut_id"));
                    userTest.setUserSolution(resultSet.getNString("ut_user_solution"));
                    userTest.setDateSolution(resultSet.getTimestamp("ut_date_solution"));
                    userTest.setStatusId(resultSet.getLong("ut_status_id"));
                    if (prevLectureId != resultSet.getLong("ul_id")) {
                        userLecture = new UserLecture();
                        userLecture.setUserId(userId);
                        userLecture.setLectureId(resultSet.getLong("ul_id"));
                        userLecture.setStatusId(resultSet.getLong("ul_status_id"));
                        userLecture.setRating(resultSet.getLong("ul_rating"));
                        userCourse.getUserLectureList().add(userLecture);
                        prevLectureId = resultSet.getLong("ul_id");
                    }
                    userLecture.getUserTestList().add(userTest);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return userCourse;  // TODO userCourse == null Реализовать "Поступить на курс"
    }
}
