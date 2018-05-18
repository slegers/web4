package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetChatMessages extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String friend_id = request.getParameter("id");
        Person p = (Person) request.getSession().getAttribute("user");
        return getChatService().getChatHistoryToJSON(p,friend_id);
    }
}
