package ru.systemoteh.educationportal.serv.dao.impl;


import ru.systemoteh.educationportal.serv.dao.EntityDao;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntityDaoImpl implements EntityDao {

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Map<String, String>> getEntitiesByCustomQuery(String customQuery) {
        List<Map<String, String>> entities = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(customQuery)) {
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    System.out.println(customQuery);
                    while (resultSet.next()) {
                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            if (i > 1) {
                                entities.get(entities.size() - 1)
                                        .put(metaData.getColumnLabel(i),
                                                String.valueOf(resultSet.getObject(i)));
                            } else {
                                Map<String, String> row = new LinkedHashMap<>();
                                row.put(metaData.getColumnLabel(i),
                                        String.valueOf(resultSet.getObject(i)));
                                entities.add(row);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            Map<String, String> errors = new LinkedHashMap<>();
            errors.put("Error code: " + String.valueOf(e.getErrorCode())
                    + ". SQL state: " + e.getSQLState(), e.getMessage());
            entities.add(errors);
        }
        return entities;
    }
}
