package ru.systemoteh.educationportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.systemoteh.educationportal.dao.RoleDao;
import ru.systemoteh.educationportal.dao.UserDao;
import ru.systemoteh.educationportal.model.Role;
import ru.systemoteh.educationportal.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;  // Description in applicationContext-data.xml

    @Autowired
    private RoleDao roleDao;  // Description in applicationContext-data.xml

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;  // Description in applicationContext-security.xml

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(2L));  // Simple user role (not admin)
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
