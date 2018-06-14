package domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import db.*;

public class ChatService {
	private PersonRepository personRepository = new PersonRepositoryStub();
	private BlogTopicRepositoryStub blogs = new BlogTopicRepositoryStub();
	private static ChatService chatService = new ChatService();
	private PuntRepoStub mem = new PuntRepoStub();
	private ChatService(){
	}

	public static ChatService getChatService(){
		return chatService;
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

	@JsonIgnore
	public void addFriend(Person p, String email) {
		Person friend = getPerson(email);
		p.addFriend(friend);
		friend.addFriend(p);
	}
	@JsonIgnore
	public ArrayList<Person> getFriendsList(Person p) {
		return p.getVriendenlijst();
	}

	public String getStatus(Person p) {
		return p.getStatus();
	}

    public void addComment(Comment comment) {
		comment.setId(getBlogs().size()+1);
		getBlog(comment.getBlogId()).addComment(comment);
    }
    public Blog getBlog(int blogID){
		return blogs.getBlog(blogID);
	}


	public void addChatMessage(String message, String userId, String time, Person p) {
		Chatmessage m = new Chatmessage(1,message,p,time);
		m.setId(p.getChatHistory().get(userId).getChatmessages().size()+1);
		Person reciever = getPerson(userId);
		p.addChatMessage(reciever,m);
		reciever.addChatMessage(p,m);
	}

    public String getChatHistoryToJSON(Person p, String friend_id) {
		return p.getChatHistory().get(friend_id).getChatmessagesToJSon();
    }

    public ArrayList<Punt> getPunten() {
		return mem.getPunten();
    }

    public void addPunt(Punt p){
		mem.add(p);
	}

}
