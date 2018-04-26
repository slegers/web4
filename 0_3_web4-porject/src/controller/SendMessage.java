package controller;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SendMessage extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("HH:mm");
        String time = format.format(date);

        return "{ \"message\":" + "\""+ message + "\"," +
                "\"time\":" + "\"" + time +  "\" }";
    }
}
