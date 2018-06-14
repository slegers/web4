package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.Punt;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPunt extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("email");

        Punt p = new Punt();
        p.setVak(request.getParameter("vak"));
        p.setNaam(request.getParameter("naam"));
        p.setPunt(Integer.parseInt(request.getParameter("punt")));
        getChatService().addPunt(p);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(getChatService().getPunten());
        } catch (JsonProcessingException e) {
        }
        return "";
    }
}
