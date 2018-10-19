package ru.systemoteh.educationportal.serv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.systemoteh.educationportal.serv.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
