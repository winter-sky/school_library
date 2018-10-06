package com.journaldev.spring.service;

import java.util.List;

import com.journaldev.spring.model.Books;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.Pupils;

public interface PersonService {

	public void addPerson(Person p);
	public void updatePerson(Person p);
	public List<Person> listPersons();
	public Person getPersonById(int id);
	public void removePerson(int id);

	public List<Pupils> listPupils();
	public void addPupil(Pupils p);
	public void addBook(Books b);
	public List<Books> listBooks();
    public void removePupil(int id);
	public void removeBook(int id);
	public List<Books> showPupilBooks(int id);
    public Pupils showPupil(int pupilId);
    public void addBookToPupil(int pupilId,int bookId);
	public void updatePupil(int pupilId);
}
