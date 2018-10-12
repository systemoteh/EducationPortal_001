package ru.systemoteh.educationportal.dao;

import ru.systemoteh.educationportal.model.UserDetail;

public interface UserDao {

    boolean saveUserDetail(UserDetail userDetail);

    boolean convertExpToCoins(long userId, long newCoins, long newExp);
}
