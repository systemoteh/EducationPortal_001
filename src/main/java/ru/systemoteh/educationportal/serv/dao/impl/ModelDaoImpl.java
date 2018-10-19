package ru.systemoteh.educationportal.serv.dao.impl;

import ru.systemoteh.educationportal.serv.dao.ModelDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ModelDaoImpl implements ModelDao {

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Map<String, List<String>> getModelsByCustomQuery(String customQuery) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(customQuery)) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        map.put(metaData.getColumnLabel(i), new ArrayList<>());
                    }
                    while (resultSet.next()) {
                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            map.get(metaData.getColumnLabel(i)).add(String.valueOf(resultSet.getObject(i)));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            map.put(e.getSQLState(), new ArrayList<String>() {{
                add(e.getMessage());
            }});
        }
        return map;
    }
}
