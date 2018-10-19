package ru.systemoteh.educationportal.prim.service;

import ru.systemoteh.educationportal.prim.model.UserDetail;

public interface UserService {

    boolean saveUserDetail(UserDetail userDetail);

    boolean convertExpToCoins(long userId, long newCoins, long newExp);

}
