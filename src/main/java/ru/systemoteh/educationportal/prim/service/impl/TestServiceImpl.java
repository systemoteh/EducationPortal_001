package ru.systemoteh.educationportal.prim.service.impl;

import ru.systemoteh.educationportal.prim.dao.TestDao;
import ru.systemoteh.educationportal.prim.service.TestService;

import java.util.List;
import java.util.Map;

public class TestServiceImpl implements TestService {

    private TestDao testDao;

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public List<Map<String, String>> getEntitiesByCustomQuery(String customQuery) {
        return testDao.getEntitiesByCustomQuery(customQuery);
    }
}
