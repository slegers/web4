package domain;

import java.util.ArrayList;
import java.util.List;

import db.*;

public class ChatService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	private BlogTopicRepositoryStub blogs = new BlogTopicRepositoryStub();
	public ChatService(){
	}
	public void setStatus(Person p, String status){
		p.setStatus(status);
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

    public ArrayList<Blog> getBlogs() {
		return blogs.getBlogs();
    }

    public ArrayList<Comment> getComments(int blogId){
		return blogs.getBlog(blogId).getComments();
	}

	public void addFriend(Person p, String userId) {
		Person friend = getPerson(userId);
		p.addFriend(friend);
	}

	public ArrayList<Person> getFriendsList(Person p) {
		return p.getVriendenlijst();
	}

	public String getStatus(Person p) {
		return p.getStatus();
	}
}
