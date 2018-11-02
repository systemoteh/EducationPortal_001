package ru.systemoteh.educationportal.prim.service;

import java.util.List;
import java.util.Map;

public interface TestService {

    List<Map<String, String>> getEntitiesByCustomQuery(String customQuery);

}
