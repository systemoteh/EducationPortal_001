package ru.systemoteh.educationportal.serv.service.impl;

import ru.systemoteh.educationportal.serv.dao.EmployeeDao;
import ru.systemoteh.educationportal.serv.model.Employee;
import ru.systemoteh.educationportal.serv.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllCourses() {
        return employeeDao.getAllCourses();
    }

    @Override
    public List<Employee> customQuery(String customQuery) {
        return employeeDao.customQuery(customQuery);
    }
}
