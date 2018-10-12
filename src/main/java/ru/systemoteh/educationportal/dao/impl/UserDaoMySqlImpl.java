package ru.systemoteh.educationportal.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.dao.UserDao;
import ru.systemoteh.educationportal.model.UserDetail;

import javax.persistence.*;
import java.util.Date;

public class UserDaoMySqlImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean saveUserDetail(UserDetail userDetail) {
        StoredProcedureQuery procedureQuery = entityManager.
                createStoredProcedureQuery("save_user_detail")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(7, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(8, Boolean.class, ParameterMode.OUT)
                .setParameter(1, userDetail.getUserId())
                .setParameter(2, userDetail.getFirsName().trim())
                .setParameter(3, userDetail.getLastName().trim())
                .setParameter(4, userDetail.getEmail().trim())
                .setParameter(5, userDetail.getBirthDate())
                .setParameter(6, userDetail.getCountry().trim())
                .setParameter(7, userDetail.getCity().trim());
        try {
            procedureQuery.execute();
            if ((boolean) procedureQuery.getOutputParameterValue(8)) {
                return true;
            } else {
                userDetail.setEmail(null);
                return false;
            }
        } catch (PersistenceException e) {
            return false;   // TODO LOGGER
        }
    }

    @Override
    public boolean convertExpToCoins(long userId, long newCoins, long newExp) {
        return new UserDaoNativeSqlImpl().convertExpToCoins(userId, newCoins, newExp);
    }

}
