package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FriendsOverview extends RequestHandler implements SynHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person p = (Person) request.getSession().getAttribute("user");
        if(p == null){
            return "";
        }
        request.setAttribute("friends",p.getVriendenlijst());
        request.getSession().setAttribute("user", p);
        return "friends_overview.jsp";
    }
}
