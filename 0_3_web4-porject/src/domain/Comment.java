package domain;

public class Comment {

    private int score;
    private int id;
    private String name;
    private String comment;

    public Comment(){

    }

    public Comment(int id, int score, String name, String comment){

    }

    public int getScore() {
        return score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <1){
            throw new IllegalArgumentException("The id of a comment should be positive");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(comment == null || comment.trim().isEmpty()){
            throw new IllegalArgumentException("The comment can't be empty or null.");
        }
        this.comment = comment;
    }

    public void setName(String name) {
        if(name == null || comment.trim().isEmpty()){
            throw new IllegalArgumentException("The name of a person who create's a comment can't be null or empty.");
        }
        this.name = name;
    }

    public void setScore(int score) {
        if(score <1 && score > 10){
            throw new IllegalArgumentException("The score of a comment should be between 1 and 10.");
        }
        this.score = score;
    }
}
