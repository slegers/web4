package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetStatus extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person p = (Person) request.getSession().getAttribute("user");
        if(p == null){
            return "";
        }
        request.getSession().setAttribute("user", p);
        return getChatService().getStatus(p);
    }
}
