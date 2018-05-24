package controller;

import domain.Person;
import domain.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Register extends RequestHandler implements SynHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();
        try{
            Person p = new Person();

            p.setFirstName(request.getParameter("firstname"));
            p.setLastName(request.getParameter("lastname"));
            p.setHashedPassword(request.getParameter("password"));
            p.setUserId(request.getParameter("email"));
            p.setStatus("online");
            p.setRole(Role.LID);
            getChatService().addPerson(p);
        }catch (IllegalArgumentException e){
            errors.add(e.getMessage());
        }catch (NullPointerException e){
            errors.add(e.getMessage());
        }

        if(errors.size() == 0){
            return "index.jsp";
        }else{
            request.setAttribute("errors",errors);
            return "registerPage.jsp";

        }


    }
}
