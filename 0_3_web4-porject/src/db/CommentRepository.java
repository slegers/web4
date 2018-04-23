package db;

import domain.Comment;
import domain.Person;

import java.util.List;

public interface CommentRepository {

    public abstract void add(Comment Comment);

    public abstract void delete(int commentId);

    public abstract Comment get(int commentId);

    public abstract List<Comment> getAll();

    public abstract void update(Comment comment);
}
