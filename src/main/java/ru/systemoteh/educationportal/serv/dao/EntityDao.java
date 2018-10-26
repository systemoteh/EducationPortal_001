package ru.systemoteh.educationportal.serv.dao;

import java.util.List;
import java.util.Map;

public interface EntityDao {

    List<Map<String, String>> getEntitiesByCustomQuery(String customQuery);

}
