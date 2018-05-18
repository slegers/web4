package domain;

public class Chatmessage {


    private Person person;
    private int id;
    private  String message;
    private String time;
    public Chatmessage(int id, String message, Person person,String time){
        setId(id);
        setMessage(message);
        setPerson(person);
        setTime(time);
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("The id of a chatmessage can't be null");
        }
        this.id = id;
    }

    public void setPerson(Person person) {
        if(person == null){
            throw new IllegalArgumentException("The person of a chatmessage can't be null.");
        }
        this.person = person;
    }

    public void setMessage(String message) {
        if(message == null || message.trim().isEmpty()){
            throw new IllegalArgumentException("the message of a chatmessage can't be null.");
        }
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
