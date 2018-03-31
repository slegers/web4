package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FriendsOverview extends RequestHandler implements SynHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return "friends_overview.jsp";
    }
}
