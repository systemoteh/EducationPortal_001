package ru.systemoteh.educationportal.serv.service.impl;

import ru.systemoteh.educationportal.serv.dao.EntityDao;
import ru.systemoteh.educationportal.serv.service.EntityService;

import java.util.List;
import java.util.Map;

public class EntityServiceImpl implements EntityService {

    private EntityDao entityDao;

    public void setEntityDao(EntityDao entityDao) {
        this.entityDao = entityDao;
    }

    @Override
    public List<Map<String, String>> getEntitiesByCustomQuery(String customQuery) {
        return entityDao.getEntitiesByCustomQuery(customQuery);
    }
}
