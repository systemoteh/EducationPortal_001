package ru.systemoteh.educationportal.serv.service.impl;

import ru.systemoteh.educationportal.serv.dao.ModelDao;
import ru.systemoteh.educationportal.serv.service.ModelService;

import java.util.List;
import java.util.Map;

public class ModelServiceImpl implements ModelService {

    private ModelDao modelDao;

    public void setModelDao(ModelDao modelDao) {
        this.modelDao = modelDao;
    }

    @Override
    public Map<String, List<String>> getModelsByCustomQuery(String customQuery) {
        return modelDao.getModelsByCustomQuery(customQuery);
    }
}
