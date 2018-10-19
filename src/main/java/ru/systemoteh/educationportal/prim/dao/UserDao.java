package ru.systemoteh.educationportal.prim.dao;

import ru.systemoteh.educationportal.prim.model.UserDetail;

public interface UserDao {

    boolean saveUserDetail(UserDetail userDetail);

    boolean convertExpToCoins(long userId, long newCoins, long newExp);
}
