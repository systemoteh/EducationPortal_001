package ru.systemoteh.educationportal.serv.service;

import ru.systemoteh.educationportal.serv.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllCourses();

    List<Employee> customQuery(String customQuery);

}
