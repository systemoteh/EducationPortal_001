package ru.systemoteh.educationportal.prim.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.systemoteh.educationportal.prim.repository.RoleRepository;
import ru.systemoteh.educationportal.prim.repository.UserRepository;
import ru.systemoteh.educationportal.prim.model.Role;
import ru.systemoteh.educationportal.prim.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserSecurityService} interface.
 */

@Service
public class UserSecurityServiceImpl implements UserSecurityService {

    @Autowired
    private UserRepository userRepository;  // Description in applicationContext-database.xml

    @Autowired
    private RoleRepository roleRepository;  // Description in applicationContext-database.xml

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;  // Description in applicationContext-security.xml

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.getOne(2L));  // Simple user role (not admin)
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
