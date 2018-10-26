package ru.systemoteh.educationportal.serv.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.serv.service.EntityService;

import javax.annotation.PostConstruct;
import javax.faces.bean.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "customQueryBean")
@RequestScoped
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomQueryBean implements Serializable {

//    private String customQuery = "";
//    private List<String> customQueryList = new ArrayList<>(Arrays.asList("", "", ""));
//    private List<Map<String, String>> entities = new ArrayList<>();
//    private List<String> columnHeaders = new ArrayList<>(Arrays.asList("Headers are empty"));
//    private int id01 = 0;
//    private int id02 = 0;
//    private boolean afterClear = false;
//
//    @ManagedProperty(value = "#{entityService}")
//    private EntityService entityService;
//
//    @Autowired(required = true)
//    @Qualifier(value = "entityService")
//    public void setEntityService(EntityService entityService) {
//        this.entityService = entityService;
//    }
//
//    @PostConstruct
//    public void init() {
//
//    }
//
//    public void getEntitiesByCustomQuery(int id) {
//        columnHeaders.clear();
//        if (customQueryList.get(id).trim().length() == 0 || customQueryList.get(id).isEmpty()) {
//            columnHeaders.add("Headers are empty");
//            entities.clear();
//            return;
//        } else {
//            entities = entityService.getEntitiesByCustomQuery(customQueryList.get(id));
//            if (entities.size() > 0) {
//                columnHeaders.addAll(entities.get(0).keySet());
//            }
//        }
//    }
//
//    public void clearQueryArea(int id) {
//        customQueryList.set(id, "");
//        columnHeaders.clear();
//        columnHeaders.add("Headers are empty");
//        entities.clear();
//        afterClear = true;
//        this.id02 = id;
//    }
//
//
//    /**********************************************************************************************
//     *  Getters and Setters
//     *********************************************************************************************/
//
//    public String getCustomQuery() {
//        if (!afterClear) {
//            if (id01 > customQueryList.size() - 1) {
//                id01 = 0;
//            }
//            String s = customQueryList.get(id01);
//            id01++;
//            return s;
//        } else {
//            afterClear = false;
//            return customQueryList.get(id02);
//        }
//    }
//
//    public void setCustomQuery(String customQuery) {
//        if (id01 > customQueryList.size() - 1) {
//            id01 = 0;
//        }
//        this.customQueryList.set(id01, customQuery);
//        id01++;
//    }
//
//    public List<String> getCustomQueryList() {
//        return customQueryList;
//    }
//
//    public void setCustomQueryList(List<String> customQueryList) {
//        this.customQueryList = customQueryList;
//    }
//
//    public List<Map<String, String>> getEntities() {
//        return entities;
//    }
//
//    public void setEntities(List<Map<String, String>> entities) {
//        this.entities = entities;
//    }
//
//    public List<String> getColumnHeaders() {
//        return columnHeaders;
//    }
//
//    public void setColumnHeaders(List<String> columnHeaders) {
//        this.columnHeaders = columnHeaders;
//    }
}
