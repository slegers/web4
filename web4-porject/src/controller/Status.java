package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Status extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
            Person p = (Person) request.getSession().getAttribute("user");
            p.setStatus(request.getParameter("status"));
            request.getSession().setAttribute("user", p);
            return p.getStatus();
    }
}
