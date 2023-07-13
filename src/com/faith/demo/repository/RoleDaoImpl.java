package com.faith.demo.repository;

import com.faith.demo.entity.Role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RoleDaoImpl implements IRoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    
    @Transactional
    public List<Role> getAllRoles() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("SELECT r FROM Role r", Role.class)
                .getResultList();
    }

    
    @Transactional
    public Role getRoleById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Role.class, id);
    }

   
    @Transactional
    public void addRole(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(role);
    }

    
    @Transactional
    public void updateRole(Role role) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(role);
    }

    
    @Transactional
    public void deleteRole(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Role role = currentSession.get(Role.class, id);
        if (role != null) {
            currentSession.delete(role);
        }
    }
}
