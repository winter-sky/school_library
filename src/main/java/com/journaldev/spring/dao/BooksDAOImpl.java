package com.journaldev.spring.dao;

import com.journaldev.spring.model.Books;
import com.journaldev.spring.model.Pupils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksDAOImpl implements BooksDAO {
    private static final Logger logger = LoggerFactory.getLogger(BooksDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public boolean checkContainsOrNot(int bookId){
        Session session = this.sessionFactory.getCurrentSession();
        List<Books> booksList = session.createCriteria(Books.class).list();

        Query query = session.createQuery("from Books where book_id=:bookId");

        query.setParameter("bookId", bookId);

        Books book = (Books) query.uniqueResult();

        return booksList.contains(book);}
}
