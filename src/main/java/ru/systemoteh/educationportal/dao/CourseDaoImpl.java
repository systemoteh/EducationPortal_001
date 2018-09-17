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
    public Course getCourseByNameEng(String nameEng) {
        // TODO
        return entityManager.find(Course.class, nameEng);
    }

    @Override
    public Course getCourseByNameRus(String nameRus) {
        // TODO
        return null;
    }

    @Override
    public Course getCourseByLink(String link) {
        // TODO
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return entityManager.createQuery("FROM Course ").getResultList();
    }
}
