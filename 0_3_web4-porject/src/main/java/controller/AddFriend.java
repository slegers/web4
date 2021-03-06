package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddFriend extends RequestHandler
{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person p = (Person) request.getSession().getAttribute("user");
        String userId = request.getParameter("email");

        getChatService().addFriend(p,userId);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(getChatService().getFriendsList(p));
        } catch (JsonProcessingException e) {
        }
        return "";
    }
}
