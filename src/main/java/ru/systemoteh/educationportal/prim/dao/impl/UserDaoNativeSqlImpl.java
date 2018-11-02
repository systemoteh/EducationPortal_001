package ru.systemoteh.educationportal.prim.dao.impl;

import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;
import ru.systemoteh.educationportal.prim.dao.UserDao;
import ru.systemoteh.educationportal.prim.model.UserDetail;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class UserDaoNativeSqlImpl implements UserDao {

    @PersistenceContext(unitName = "edu_portal_prim")
    private EntityManager entityManager;

    @Override
    @Transactional(value = "edu_portal_prim")
    public boolean saveUserDetail(UserDetail userDetail) {
        //  Check whether there are still users in the database with the same e-mail, except the current user
        String querySelect = "SELECT 1 FROM education_portal.user_detail " +
                "WHERE e_mail = trim(?) AND user_id != ? ";
        Query nativeQuerySelect = entityManager.createNativeQuery(querySelect);
        nativeQuerySelect.setParameter(1, userDetail.getEmail());
        nativeQuerySelect.setParameter(2, userDetail.getUserId());
        try {
            if (nativeQuerySelect.getResultList().size() > 0) {
                userDetail.setEmail(null);
                return false;
            }
        } catch (TransactionSystemException e) {
            return false;   // TODO LOGGER
        }

        String queryUpdate = "UPDATE education_portal.user_detail SET first_name = ?, " +
                "last_name = ?, e_mail = ?, birth_date = ?, " +
                "country = ?, city = ? WHERE user_id = ?";
        Query nativeQueryUpdate = entityManager.createNativeQuery(queryUpdate);
        nativeQueryUpdate.setParameter(1, userDetail.getFirsName().trim());
        nativeQueryUpdate.setParameter(2, userDetail.getLastName().trim());
        nativeQueryUpdate.setParameter(3, userDetail.getEmail().trim());
        nativeQueryUpdate.setParameter(4, userDetail.getBirthDate());
        nativeQueryUpdate.setParameter(5, userDetail.getCountry().trim());
        nativeQueryUpdate.setParameter(6, userDetail.getCity().trim());
        nativeQueryUpdate.setParameter(7, userDetail.getUserId());
        try {
            return nativeQueryUpdate.executeUpdate() > 0;
        } catch (Exception e) {
            return false;   // TODO LOGGER
        }
    }

    @Override
    @Transactional(value = "edu_portal_prim")
    public boolean convertExpToCoins(long userId, long newCoins, long newExp) {
        String queryUpdate = "UPDATE user_detail SET coins = ?, experience = ? WHERE user_id = ?";
        Query nativeQueryUpdate = entityManager.createNativeQuery(queryUpdate);
        nativeQueryUpdate.setParameter(1, newCoins);
        nativeQueryUpdate.setParameter(2, newExp);
        nativeQueryUpdate.setParameter(3, userId);
        try {
            return nativeQueryUpdate.executeUpdate() > 0;
        } catch (PersistenceException e) {
            return false;   // TODO LOGGER
        }
    }
}
