package com.journaldev.spring.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.journaldev.spring.model.Books;
import com.journaldev.spring.model.Pupils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addPerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

    @Override
    public void addPupil(Pupils p) {
        Session session = this.sessionFactory.getCurrentSession();
//        for(Books book: p.getBooks()){
//            session.persist(book);
//        }
        session.persist(p);
        System.out.println("XXXXXX Add person [name=" + p.getName() + ", country=" + p.getGrade() + ']');
        logger.info("Pupil saved successfully, Person Details="+p);
    }

    @Override
    public void addBook(Books b){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(b);
        logger.info("Book saved successfully, Book Details="+b);
    };

	@Override
	public void updatePerson(Person p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> listPersons() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for(Person p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
	}

	@Override
	public List<Pupils> listPupils(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Pupils> pupilsList = session.createQuery("from Pupils").list();
		for(Pupils p : pupilsList){
			logger.info("Pupil List::"+p);
		}
		System.out.println("xxx");
		return pupilsList;
	};

    @Override
    public List<Books> listBooks(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Books> booksList = session.createQuery("from Books").list();
        for(Books b : booksList){
            logger.info("Books List::"+b);
        }
        System.out.println("xxx");
        return booksList;
    }

    @Override
    public List<Books> showPupilBooks(int pupilId){
        Session session = this.sessionFactory.getCurrentSession();
        System.out.printf("Show pupil books: " + pupilId);

        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");

        query.setParameter("pupilId", pupilId);

        List<Pupils> pupils = query.list();

        assert pupils.size() <= 1;

        if (!pupils.isEmpty()) {
            Set<Books> booksList = pupils.get(0).getBooks();

            for (Books b : booksList) {
                logger.info("Books List::" + b);
            }
            System.out.println("xxx");
            return new ArrayList<Books>(booksList);
        }

        return Collections.emptyList();
    }

//    @Override
//    public List<Books> pupilsBooks(Pupils p){
//        Session session = this.sessionFactory.getCurrentSession();
//        System.out.printf("Show pupil books: " + p.getPupilId());
//
//        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");
//
//        query.setParameter("pupilId", p.getPupilId());
//
//        List<Pupils> pupils = query.list();
//
//        assert pupils.size() <= 1;
//
//        if (!pupils.isEmpty()) {
//            Set<Books> booksList = pupils.get(0).getBooks();
//
//            for (Books b : booksList) {
//                logger.info("Books List::" + b);
//            }
//            return new ArrayList<Books>(booksList);
//        }
//
//        return Collections.emptyList();
//    }

	@Override
	public Person getPersonById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Person p = (Person) session.load(Person.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removePerson(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Person p = (Person) session.load(Person.class, id);
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}

    @Override
    public void removePupil(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Pupils p = (Pupils) session.load(Pupils.class, id);
        if(null != p){
            session.delete(p);
        }
        logger.info("Pupil deleted successfully, person details="+p);
    }

    @Override
    public void removeBook(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Books b = (Books) session.load(Books.class, id);
        if(null != b){
            session.delete(b);
        }
        logger.info("Book deleted successfully, person details="+b);}

}
