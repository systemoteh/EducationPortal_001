package ru.systemoteh.educationportal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
}
