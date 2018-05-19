package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetUsers extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            System.out.println(mapper.writeValueAsString(getChatService().getPersons()));
            return mapper.writeValueAsString(getChatService().getPersons());
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(mapper.writeValueAsString(getChatService().getPersons()));
        return mapper.writeValueAsString(getChatService().getPersons());
    }
}
