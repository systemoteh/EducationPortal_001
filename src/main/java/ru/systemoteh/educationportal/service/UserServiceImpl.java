package ru.systemoteh.educationportal.service;

import ru.systemoteh.educationportal.dao.UserDao;
import ru.systemoteh.educationportal.model.Lecture;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
