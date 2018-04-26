package db;

import domain.Blog;

import java.util.ArrayList;
import java.util.HashMap;

public class BlogTopicRepositoryStub {

    private HashMap<Integer, Blog> blogs;

    public ArrayList<Blog> getBlogs(){
        return new ArrayList<>(blogs.values());
    }

    public BlogTopicRepositoryStub(){
        blogs = new HashMap<>();
        blogs.put(1,new Blog(1,"Moet de model met web4 worden gegeven?"));
        blogs.put(2,new Blog(2,"Wat zijn de examenvragen van web4?"));
        blogs.put(3,new Blog(3,"Waren de segregatiewetten van de USA anders dan de neuenbergwetten?"));
        blogs.put(4,new Blog(4,"Wat was er eerst, het kip of het ei?"));
        blogs.put(5,new Blog(5,"2B || !2B?"));
    }

    public Blog getBlog(int blogId){
        return blogs.get(blogId);
    }


}
