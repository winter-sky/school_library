package mainpackage.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mainpackage.model.Books;
import mainpackage.model.Pupils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mainpackage.model.Person;

import javax.persistence.criteria.CriteriaBuilder;

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

//    @Override
//    public void addPupilBook(Books b,int pupilId){
//        Session session = this.sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");
//        query.setParameter("pupilId", pupilId);
//        Pupils pupil = (Pupils)query.uniqueResult();
//        pupil.setBook(b);
//        session.persist(b);
//    }

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
        return session.createCriteria(Pupils.class).list();

//		Session session = this.sessionFactory.getCurrentSession();
//		List<Pupils> pupilsList = session.createQuery("from Pupils").list();
//		for(Pupils p : pupilsList){
//			logger.info("Pupil List::"+p);
//		}
//		return pupilsList;
	};

    @Override
    public List<Books> listBooks(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Books> booksList = session.createQuery("from Books").list();
        for(Books b : booksList){
            logger.info("Books List::"+b);
        }
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
            List<Books> booksList = pupils.get(0).getBooks();

            for (Books b : booksList) {
                logger.info("Books List::" + b);
            }
            return new ArrayList<Books>(booksList);
        }

        return Collections.emptyList();
    }

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
        if(p.getBooks().isEmpty()){
            session.delete(p);
            logger.info("Pupil deleted successfully, pupils details="+p);
        }
        logger.info("Pupil is not deleted, pupils details="+p);
    }

    @Override
    public void removeBook(int id){
        Session session = this.sessionFactory.getCurrentSession();
        List<Pupils> pupilsList = session.createQuery("from Pupils").list();

        List<Books> listAllBooks=session.createCriteria(Books.class).list();

        for(Pupils p : pupilsList){
            List<Books> listPupilBooks = p.getBooks();
            listAllBooks.removeAll(listPupilBooks);
        }
        System.out.println("listAllPupilsBooks"+listAllBooks);

        List<Books> listFreeBooks=listAllBooks;

        Books b = (Books) session.load(Books.class, id);
        if(listFreeBooks.contains(b)){
            session.delete(b);
        }
        logger.info("Book deleted successfully, book details="+b);}


    @Override
    public Pupils showPupil(int pupilId){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");

        query.setParameter("pupilId", pupilId);

        Pupils pupil = (Pupils)query.uniqueResult();
        return pupil;
    }

    @Override
    public void addBookToPupil(int pupilId,int bookId){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");
        query.setParameter("pupilId", pupilId);
        Pupils pupil = (Pupils)query.uniqueResult();
        System.out.println(pupil.getName());
        System.out.println("Было столько книг "+pupil.getBooks());

        Query query2 = session.createQuery("from Books where book_id=:bookId");
        query2.setParameter("bookId", bookId);
        Books book = (Books)query2.uniqueResult();
        System.out.println(book.getName());
        pupil.setBook(book);
        System.out.println("Стало столько книг "+pupil.getBooks());
        //session.merge(pupil);

    }

    @Override
    public void updatePupil(int pupilId) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");
        query.setParameter("pupilId", pupilId);
        Pupils p = (Pupils)query.uniqueResult();
        session.update(p);
    }

    @Override
    public List<Books> getFreeBooks(){
        Session session = this.sessionFactory.getCurrentSession();
        List<Pupils> pupilsList = session.createQuery("from Pupils").list();

        List<Books> listAllBooks=session.createCriteria(Books.class).list();

        for(Pupils p : pupilsList){
            List<Books> listPupilBooks = p.getBooks();
            listAllBooks.removeAll(listPupilBooks);
        }
        System.out.println("listAllPupilsBooks"+listAllBooks);

        List<Books> listFreeBooks=listAllBooks;

        System.out.println("listFreeBooks "+listFreeBooks);

        return listFreeBooks;
    };
}
