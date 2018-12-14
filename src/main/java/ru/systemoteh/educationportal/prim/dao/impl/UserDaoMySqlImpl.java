package ru.systemoteh.educationportal.prim.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.UserDao;
import ru.systemoteh.educationportal.prim.model.UserDetail;

import javax.persistence.*;
import java.util.Date;

public class UserDaoMySqlImpl implements UserDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(value = "edu_portal_prim", readOnly = true)
    public boolean saveUserDetail(UserDetail userDetail) {
        StoredProcedureQuery procedureQuery = entityManager.
                createStoredProcedureQuery("save_user_detail")
                .registerStoredProcedureParameter(1, Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(5, Boolean.class, ParameterMode.IN)
                .registerStoredProcedureParameter(6, Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter(7, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(8, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(9, Boolean.class, ParameterMode.OUT)
                .setParameter(1, userDetail.getUserId())
                .setParameter(2, userDetail.getFirsName().trim())
                .setParameter(3, userDetail.getLastName().trim())
                .setParameter(4, userDetail.getEmail().trim())
                .setParameter(5, userDetail.isGender())
                .setParameter(6, userDetail.getBirthDate())
                .setParameter(7, userDetail.getCountry().trim())
                .setParameter(8, userDetail.getCity().trim());
        try {
            procedureQuery.execute();
            if ((boolean) procedureQuery.getOutputParameterValue(9)) {
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
        return userDao.convertExpToCoins(userId, newCoins, newExp);
    }

}
