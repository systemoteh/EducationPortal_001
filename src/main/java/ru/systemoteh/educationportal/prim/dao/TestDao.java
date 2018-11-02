package ru.systemoteh.educationportal.prim.dao;

import java.util.List;
import java.util.Map;

public interface TestDao {

    List<Map<String, String>> getEntitiesByCustomQuery(String customQuery);

}
