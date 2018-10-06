package com.journaldev.spring;

import com.journaldev.spring.model.Books;
import com.journaldev.spring.model.Pupils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.PersonService;

import java.util.List;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired(required=true)
	@Qualifier(value="personService")
	public void setPersonService(PersonService ps){
		this.personService = ps;
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

	@RequestMapping(value = "/pupils", method = RequestMethod.GET)
    public String listPupils(Model model) {

        model.addAttribute("pupils", new Pupils());
        model.addAttribute("listPupils", this.personService.listPupils());System.out.println("xxx");
        return "pupils";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", new Books());
        model.addAttribute("listBooks", this.personService.listBooks());System.out.println("xxx");
        return "books";
    }



    @RequestMapping(value = "/pupils_books/{id}", method = RequestMethod.GET)
    public String showPupilBooks(@PathVariable("id") int id,Model model) {
        //TODO
        model.addAttribute("books", new Books());
        model.addAttribute("showPupilBooks", this.personService.showPupilBooks(id));
        return "pupils_books";
    }
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		System.out.println("XXXXXX Add person [name=" + p.getName() + ", country=" + p.getCountry() + ']');
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		return "redirect:/persons";
	}

    @RequestMapping(value= "/pupils/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("pupils") Pupils p){
        System.out.println("XXXXXX Add person [name=" + p.getName() + ", country=" + p.getGrade() + ']');

            this.personService.addPupil(p);

        return "redirect:/pupils";
    }


    @RequestMapping(value= "/book/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("books") Books b){
        this.personService.addBook(b);
        return "redirect:/books";
    }


	@RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
		
        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping("/removepupil/{id}")
    public String removePupil(@PathVariable("id") int id){

        this.personService.removePupil(id);
        return "redirect:/pupils";
    }

    @RequestMapping("/showpupil/{id}")
    public String showPupil(@PathVariable("id") int id){

        this.personService.showPupilBooks(id);
        return "redirect:/pupils_books";
    }

    @RequestMapping("/removebook/{id}")
    public String removeBook(@PathVariable("id") int id){

        this.personService.removeBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }

    @RequestMapping(value = "/add_pupil_book/{id}", method = RequestMethod.GET)
    public String showPupil(@PathVariable("id") int id,Model model) {
        model.addAttribute("showPupil", this.personService.showPupil(id));
        model.addAttribute("listBooks", this.personService.listBooks());
        return "add_pupil_book";
    }

    @RequestMapping(value = "/addBookToPupil/{pupilId}/{bookId}", method = RequestMethod.GET)
    public String addBookToPupil(@PathVariable("pupilId") int pupilId,@PathVariable("bookId") int bookId) {
    this.personService.addBookToPupil(pupilId,bookId);
    //this.personService.updatePupil(pupilId);
        return "redirect:/pupils";
    }

}
