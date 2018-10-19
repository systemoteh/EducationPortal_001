package ru.systemoteh.educationportal.serv.dao;

import ru.systemoteh.educationportal.serv.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllCourses();

    List<Employee> customQuery(String customQuery);

}
