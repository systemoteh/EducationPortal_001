package ru.systemoteh.educationportal.serv.service;

import java.util.List;
import java.util.Map;

public interface EntityService {

    List<Map<String, String>> getEntitiesByCustomQuery(String customQuery);

}
