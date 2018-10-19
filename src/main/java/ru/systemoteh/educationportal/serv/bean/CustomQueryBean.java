package ru.systemoteh.educationportal.serv.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.serv.service.ModelService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "customQueryBean")
@SessionScoped
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomQueryBean implements Serializable {

    private String customQuery;
    private Map<String, List<String>> models;
    private List<String> selectedColumns = new ArrayList<>();


    @ManagedProperty(value = "#{modelService}")
    private ModelService modelService;

    @Autowired(required = true)
    @Qualifier(value = "modelService")
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @PostConstruct
    public void init() {

    }

    public void getModelByCustomQuery() {
        if (customQuery.trim().length() == 0 || customQuery.isEmpty()) {
            customQuery = "SELECT * FROM employee";
        }
        models = modelService.getModelsByCustomQuery(customQuery);
        if (models.size() > 0) {

        }
    }


    /**********************************************************************************************
     *  Getters and Setters
     *********************************************************************************************/

    public String getCustomQuery() {
        return customQuery;
    }

    public void setCustomQuery(String customQuery) {
        this.customQuery = customQuery;
    }

    public Map<String, List<String>> getModels() {
        return models;
    }

    public void setModels(Map<String, List<String>> models) {
        this.models = models;
    }

    public List<String> getSelectedColumns() {
        return selectedColumns;
    }

    public void setSelectedColumns(List<String> selectedColumns) {
        this.selectedColumns = selectedColumns;
    }
}
