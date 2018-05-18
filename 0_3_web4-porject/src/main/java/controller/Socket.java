package controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ChatService;
import domain.Comment;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;
import org.json.JSONObject;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint("/socket")
public class Socket {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
    private ChatService service;

    public Socket(){
        service = ChatService.getChatService();
    }
    @OnOpen
    public void onOpen(Session session){
        sessions.add(session);
    }

    @OnMessage
    public void onMessage(String message, Session session){
        ObjectMapper mapper = new ObjectMapper();
        try {

            Comment comment = mapper.readValue(message, Comment.class);
            service.addComment(comment);
            message = comment.toJSON();
            sendMessageToAll(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session){
        sessions.remove(session);
    }

    private void sendMessageToAll(String message){
        for(Session s : sessions){
            try {
                s.getBasicRemote().sendText(message);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
