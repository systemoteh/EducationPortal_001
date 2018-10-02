package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

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
