package ru.systemoteh.educationportal.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.bean.UserBean;
import ru.systemoteh.educationportal.repository.UserRepository;
import ru.systemoteh.educationportal.model.Role;
import ru.systemoteh.educationportal.model.User;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserDetailsService} interface.
 */

public class UserDetailsSecurityServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;  // Description in applicationContext-data.xml

    @Autowired
    private UserBean userBean;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        user.getUserDetail().setLastVisit(new Date());
        userBean.setCurrentUser(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
