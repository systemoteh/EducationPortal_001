package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Integer userId) {
        // TODO
        return null;
    }



}
