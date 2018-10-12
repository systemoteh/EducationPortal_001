package ru.systemoteh.educationportal.dao.impl;

import ru.systemoteh.educationportal.dao.CourseDao;
import ru.systemoteh.educationportal.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CourseDaoJpaImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course getCourseById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("FROM Course ").getResultList();
    }

}
