package domain;

import com.fasterxml.jackson.annotation.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
	@JsonIgnoreProperties(value = { "vriendenlijst" })
	private String userId;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	private Role role;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonIgnore
	private HashMap<String,Person> vriendenlijst;
	private String status;
	@JsonIgnore
	private HashMap<String,ChatHistory> chatHistory;

	public Person(String userId, String password, String firstName,
			String lastName,Role role,String status) {
		vriendenlijst = new HashMap<>();
		chatHistory = new HashMap<>();
		setUserId(userId);
		setHashedPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		setRole(role);
		setStatus(status);
	}

	public Person(String userId, String password, String salt,
				  String firstName, String lastName,Role role) {
		this(userId,password,firstName,lastName,role,"online");
	}

	public Person() {

	}
	@Override
	public String toString(){
		return "Person: \n"
				+ "firstname: "+ getFirstName()
				+ "lastname: " + getLastName()
				+ "password: " + getPassword()
				+ "userid: "   + getUserId()
				+ "role: "     + getRole()
				+ "status: "   + getStatus()
				+ "salt: "     + getSalt();
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role=role;
	}
	

	public void setUserId(String userId) {
		if (userId.isEmpty()) {
			throw new IllegalArgumentException("No id given");
		}
		String USERID_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern p = Pattern.compile(USERID_PATTERN);
		Matcher m = p.matcher(userId);
		if (!m.matches()) {
			throw new IllegalArgumentException("Email not valid");
		}
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public boolean isCorrectPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		return getPassword().equals(hashPassword(password, getSalt()));
	}

	public void setPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = password;
	}

	public void setHashedPassword(String password) {
		if (password.isEmpty()) {
			throw new IllegalArgumentException("No password given");
		}
		this.password = hashPassword(password);
	}

	private String hashPassword(String password) {
		SecureRandom random = new SecureRandom();
		byte[] seed = random.generateSeed(20);

		String salt = new BigInteger(1, seed).toString(16);
		this.setSalt(salt);

		return hashPassword(password, salt);
	}

	private String hashPassword(String password, String seed) {
		String hashedPassword = null;
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(salt.getBytes("UTF-8"));
			crypt.update(password.getBytes("UTF-8"));
			hashedPassword = new BigInteger(1, crypt.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new DomainException(e.getMessage(), e);
		} catch (UnsupportedEncodingException e) {
			throw new DomainException(e.getMessage(), e);
		}
		return hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSalt() {
		return salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			throw new IllegalArgumentException("No firstname given");
		}
		this.firstName = firstName;// firstName;

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName.isEmpty()) {
			throw new IllegalArgumentException("No last name given");
		}
		this.lastName = lastName;
	}

	public void setStatus(String status) {
		if(status.trim().isEmpty()){
			this.status = "Online";
		}
		this.status = status;
	}
	public String getStatus(){
		return status;
	}

	public void addFriend(Person friend){
		chatHistory.put(friend.getUserId(),new ChatHistory());
		vriendenlijst.put(friend.getUserId(),friend);
	}

	public void removeFriend(Person p){
		vriendenlijst.remove(p);
	}

	public void editFriend(Person p){
		addFriend(p);
	}

	@JsonIgnore
	@JsonProperty("vriendenlijst")
	public ArrayList<Person> getVriendenlijst() {
		return new ArrayList<>(vriendenlijst.values());
	}
	@JsonIgnore
	public HashMap<String,Person> getVriendenlijstMap() {
		return vriendenlijst;
	}

	@JsonIgnore
	public HashMap<String, ChatHistory> getChatHistory() {
		return chatHistory;
	}
	@JsonIgnore
	public void addChatMessage(Person friend, Chatmessage chatmessage){
		chatHistory.get(friend.getUserId()).addChatMessage(chatmessage);
	}
	@JsonIgnore
	public void setChatHistory(HashMap<String, ChatHistory> chatHistory) {
		this.chatHistory = chatHistory;
	}

}
