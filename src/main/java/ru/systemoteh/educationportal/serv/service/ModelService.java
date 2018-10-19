package ru.systemoteh.educationportal.serv.service;

import java.util.List;
import java.util.Map;

public interface ModelService {

    Map<String, List<String>> getModelsByCustomQuery(String customQuery);

}
