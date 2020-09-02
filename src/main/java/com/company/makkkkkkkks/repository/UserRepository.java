package com.company.makkkkkkkks.repository;

import com.company.makkkkkkkks.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void createUser(User user) {
        getCurrentSession().persist(user);
    }

    public User getUserById(Long id) {
        return (User) getCurrentSession().createQuery("SELECT u From User u WHERE id = " + id, User.class).
                list().get(0); //HQL - Hibernate query lang.
    }

    public void deleteUser(Long id) {
        getCurrentSession().delete(getUserById(id));
    }

    public List<User> showAllUsers() {
        return getCurrentSession().createQuery("SELECT u From User u", User.class).getResultList();
    }

    public boolean updateUser(User user) {
        getCurrentSession().update(user);
        return true;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
