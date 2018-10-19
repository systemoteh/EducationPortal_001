package ru.systemoteh.educationportal.prim.dao.impl;

import ru.systemoteh.educationportal.prim.dao.UserDao;
import ru.systemoteh.educationportal.prim.model.UserDetail;

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
