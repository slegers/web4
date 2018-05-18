package db;

import domain.Comment;
import domain.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepositoryStub implements CommentRepository{

    private Map<Integer, Comment> comments = new HashMap<Integer, Comment>();

    public CommentRepositoryStub(){
        comments = new HashMap<>();
    }

    @Override
    public void add(Comment comment) {
        comments.put(comment.getId(),comment);
    }

    @Override
    public void delete(int commentId) {
        comments.remove(commentId);
    }

    @Override
    public Comment get(int commentId) {
        return comments.get(commentId);
    }

    @Override
    public List<Comment> getAll() {
        return new ArrayList<>(comments.values());
    }

    @Override
    public void update(Comment comment) {
        add(comment);
    }
}
