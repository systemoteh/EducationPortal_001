package ru.systemoteh.educationportal.prim.service.impl;

import ru.systemoteh.educationportal.prim.dao.UserDao;
import ru.systemoteh.educationportal.prim.model.UserDetail;
import ru.systemoteh.educationportal.prim.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        return userDao.saveUserDetail(userDetail);
    }

    @Override
    public boolean convertExpToCoins(long userId, long newCoins, long newExp) {
        return userDao.convertExpToCoins(userId, newCoins, newExp);
    }
}
