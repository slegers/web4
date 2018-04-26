package domain;

public class Chatmessage {


    private Person person;
    private  String message;

    public Chatmessage(String message, Person person){
        setMessage(message);
        setPerson(person);
    }

    private void setPerson(Person person) {
        if(person == null){
            throw new IllegalArgumentException("The person of a chatmessage can't be null.");
        }

    }

    private void setMessage(String message) {

    }
}
