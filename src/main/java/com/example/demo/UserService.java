package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.query.sql.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserDao userDao;

    public List<TUser> findAllUsers() {
        return userDao.findAll();
    }

    public TUser saveUser(TUser user) {
        user.setLoadKey(new LoadKey(user.getLoadKey().getUserId(), user.getLoadKey().getUserName()));
        return userDao.save(user);
    }

    public void deleteUser(Long id,String userName) {
        userDao.deleteById(new LoadKey(id,userName));
    }

    public Optional<TUser> loadUser(LoadKey id){
        return userDao.findById(id);
    }
    public List<TUser> findAll() {
        String sb = " select a.user_id userId, a.user_name userName " +
                " from t_user as a " +
                " where user_id > 1 " +
                " order by user_id asc ";
        Query query = entityManager.createNativeQuery(sb);
        query.unwrap(NativeQueryImpl.class).setResultListTransformer(Transformers.aliasToBean(TUser.class));
        return query.getResultList();
    }

    public Long getCnt() {
        String sb = " select count(1) " +
                " from TUser ";
        Query query = entityManager.createQuery(sb);
        return (Long) query.getSingleResult();
    }
}
