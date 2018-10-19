package ru.systemoteh.educationportal.serv.dao;

import java.util.List;
import java.util.Map;

public interface ModelDao {

    Map<String, List<String>> getModelsByCustomQuery(String customQuery);

}
