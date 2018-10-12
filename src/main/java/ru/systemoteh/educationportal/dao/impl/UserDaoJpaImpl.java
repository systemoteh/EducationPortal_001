package ru.systemoteh.educationportal.dao.impl;

import ru.systemoteh.educationportal.dao.UserDao;
import ru.systemoteh.educationportal.model.UserDetail;

public class UserDaoJpaImpl implements UserDao {

    @Override
    public boolean saveUserDetail(UserDetail userDetail) {
        // TODO
        return false;
    }

    @Override
    public boolean convertExpToCoins(long userId, long newCoins, long newExp) {
        // TODO
        return false;
    }
}
