package com.company.makkkkkkkks.repository;

import com.company.makkkkkkkks.entity.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void createBooks(Books books) {
        getCurrentSession().persist(books);
    }

    public Books getBooksById(Long id) {
        return getCurrentSession().createQuery("SELECT u From Books u WHERE id = " + id, Books.class).
                list().get(0);
    }

    public void deleteBooks(Long id) {
        getCurrentSession().delete(getBooksById(id));
    }

    public List<Books> showAllBooks(Long id) {
        return getCurrentSession().createQuery("SELECT b From Books b WHERE Books.owner=" + id, Books.class).getResultList();
    }

    public boolean updateBooks(Books books) {
        getCurrentSession().update(books);
        return true;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
