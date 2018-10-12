package ru.systemoteh.educationportal.service;

import ru.systemoteh.educationportal.model.UserDetail;

public interface UserService {

    boolean saveUserDetail(UserDetail userDetail);

    boolean convertExpToCoins(long userId, long newCoins, long newExp);

}
