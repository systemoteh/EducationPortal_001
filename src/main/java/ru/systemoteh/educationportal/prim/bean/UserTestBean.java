package ru.systemoteh.educationportal.prim.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.systemoteh.educationportal.prim.model.UserTest;
import ru.systemoteh.educationportal.prim.service.TestService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "testBean")
@RequestScoped
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
@Setter
public class UserTestBean {

    private List<Map<String, String>> entities = new ArrayList<>();
    private List<String> columnHeaders = new ArrayList<>(Arrays.asList("..."));
    private List<UserTest> selectedUserTestList = new ArrayList<>();

    @ManagedProperty(value = "#{userBean}")
    private UserBean userBean;

    @ManagedProperty(value = "#{testService}")
    private TestService testService;


    @Autowired(required = true)
    @Qualifier(value = "userBean")
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }


    @Autowired(required = true)
    @Qualifier(value = "testService")
    public void setTestService(TestService testService) {
        this.testService = testService;
    }


    @PostConstruct
    public void init() {
        selectedUserTestList = userBean.getSelectedUserLecture().getUserTestList();
    }


    public void getEntitiesByCustomQuery(int id) {
        columnHeaders.clear();
        if (selectedUserTestList.get(id).getUserSolution().trim().length() == 0) {
            columnHeaders.add("Headers are empty");
            entities.clear();
            return;
        } else {
            entities = testService.getEntitiesByCustomQuery(selectedUserTestList.get(id).getUserSolution());
            if (entities.size() > 0) {
                columnHeaders.addAll(entities.get(0).keySet());
            }
        }
    }

    public void clearQueryArea(int id) {
        selectedUserTestList.get(id).setUserSolution("");
        columnHeaders.clear();
        columnHeaders.add("...");
        entities.clear();
    }

}
