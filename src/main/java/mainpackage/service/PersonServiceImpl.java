package mainpackage.service;

import java.util.List;

import mainpackage.model.Books;
import mainpackage.model.Pupils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mainpackage.dao.PersonDAO;
import mainpackage.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonDAO personDAO;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public void addPerson(Person p) {
		this.personDAO.addPerson(p);
	}

	@Override
	@Transactional
	public void updatePerson(Person p) {
		this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public List<Pupils> listPupils(){return this.personDAO.listPupils();}

    @Override
    @Transactional
    public List<Books> listBooks(){return this.personDAO.listBooks();}

    @Override
    @Transactional
    public void addPupil(Pupils p){this.personDAO.addPupil(p);}

    @Override
    @Transactional
    public void addBook(Books b){this.personDAO.addBook(b);}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}

    @Override
    @Transactional
    public void removePupil(int id){this.personDAO.removePupil(id);}

    @Override
    @Transactional
    public void removeBook(int id){this.personDAO.removeBook(id);}

    @Override
    @Transactional
    public List<Books> showPupilBooks(int id) {
        return personDAO.showPupilBooks(id);
    }

	@Override
	@Transactional
    public Pupils showPupil(int pupilId){return personDAO.showPupil(pupilId);}

    @Override
    @Transactional
    public void addBookToPupil(int pupilId,int bookId){this.personDAO.addBookToPupil(pupilId,bookId);}

	@Override
	@Transactional
	public void updatePupil(int pupilId){this.personDAO.updatePupil(pupilId);}

	@Override
	@Transactional
	public List<Books> getFreeBooks(){return this.personDAO.getFreeBooks();}
}
