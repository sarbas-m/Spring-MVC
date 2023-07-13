package com.faith.demo.repository;

import com.faith.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImple implements IUserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(User.class, id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        if (user != null) {
            currentSession.delete(user);
        }
    }


}
