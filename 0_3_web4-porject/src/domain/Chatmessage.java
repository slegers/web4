package domain;

public class Chatmessage {


    private Person person;
    private int id;
    private  String message;

    public Chatmessage(int id, String message, Person person){
        setId(id);
        setMessage(message);
        setPerson(person);
    }

    private void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("The id of a chatmessage can't be null");
        }
        this.id = id;
    }

    private void setPerson(Person person) {
        if(person == null){
            throw new IllegalArgumentException("The person of a chatmessage can't be null.");
        }

    }

    private void setMessage(String message) {
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
}
