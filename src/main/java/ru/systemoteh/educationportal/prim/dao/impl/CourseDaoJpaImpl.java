package ru.systemoteh.educationportal.prim.dao.impl;

import ru.systemoteh.educationportal.prim.dao.CourseDao;
import ru.systemoteh.educationportal.prim.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CourseDaoJpaImpl implements CourseDao {

    @PersistenceContext(unitName = "edu_portal_prim")
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
