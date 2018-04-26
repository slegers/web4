package domain;

import java.util.ArrayList;
import java.util.HashMap;

public class Blog {

    private HashMap<Integer,Comment> comments;
    private String title;
    private int id;
    public Blog(int id, String title){
        this.id = id;
        comments = new HashMap<>();
        setTitle(title);
    }

    private void setTitle(String title) {
        if(title == null && title.trim().isEmpty()){
            throw new IllegalArgumentException("The title of a blog can't be null or empty");
        }
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public ArrayList<Comment> getComments(){
        return new ArrayList<>(comments.values());
    }

    public void addComment(Comment comment){
        comment.setId(comments.size());
        comments.put(comment.getId(),comment);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
