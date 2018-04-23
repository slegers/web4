package domain;

import java.util.List;

import db.CommentRepository;
import db.CommentRepositoryStub;
import db.PersonRepository;
import db.PersonRepositoryStub;

public class ChatService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	private CommentRepository comment = new CommentRepositoryStub();

	public ChatService(){
	}
	
	public Person getPerson(String personId)  {
		return getPersonRepository().get(personId);
	}

	public List<Person> getPersons() {
		return getPersonRepository().getAll();
	}

	public void addPerson(Person person) {
		getPersonRepository().add(person);
	}

	public void updatePersons(Person person) {
		getPersonRepository().update(person);
	}

	public void deletePerson(String id) {
		getPersonRepository().delete(id);
	}
	
	public Person getAuthenticatedUser(String email, String password) {
		return getPersonRepository().getAuthenticatedUser(email, password);
	}

	private PersonRepository getPersonRepository() {
		return personRepository;
	}
}
