package ru.systemoteh.educationportal.serv.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.serv.dao.EmployeeDao;
import ru.systemoteh.educationportal.serv.model.Employee;
import ru.systemoteh.educationportal.prim.model.User;
import ru.systemoteh.educationportal.serv.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManagerPrim;

    @PersistenceContext(unitName = "edu_portal_serv")
    private EntityManager entityManagerServ;

    @Autowired
    private EmployeeRepository employeeRepository;

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    @Transactional(value = "edu_portal_prim")
    public List<Employee> getAllCourses() {
        List<Employee> employees = entityManagerServ.createQuery("FROM Employee ").getResultList();
        List<User> users = entityManagerPrim.createNativeQuery("SELECT * FROM user").getResultList();
        List<Employee> employees1 = entityManagerServ.createNativeQuery("SELECT * FROM employee ").getResultList();
        List<Employee> employees2 = employeeRepository.findAll();
        return employees;
    }

    @Override
    public List<Employee> customQuery(String customQuery) {
        Query nativeQuery = entityManagerServ.createNativeQuery(customQuery, Employee.class);
        List<Employee> employees = nativeQuery.getResultList();
        return employees;
    }
}
