package ru.systemoteh.educationportal.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.bean.LectureBean;
import ru.systemoteh.educationportal.bean.UserBean;
import ru.systemoteh.educationportal.dao.UserDao;
import ru.systemoteh.educationportal.dao.security.UserSecurityDao;
import ru.systemoteh.educationportal.model.Lecture;
import ru.systemoteh.educationportal.model.Role;
import ru.systemoteh.educationportal.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService} interface.
 */

public class UserDetailsSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserSecurityDao userSecurityDao;  // Description in applicationContext-data.xml

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBean userBean;

    @Autowired
    private LectureBean lectureBean;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userSecurityDao.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        userBean.setCurrentUser(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
