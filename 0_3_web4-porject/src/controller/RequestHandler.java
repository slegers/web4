package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ChatService;
import domain.Person;
import domain.Role;

import java.io.IOException;

public abstract class RequestHandler {
	
	private ChatService chatService;
	
	public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void setModel (ChatService chatService) {
		this.chatService = chatService;
	}

	public ChatService getChatService() {
		return chatService;
	}
	
	protected boolean isFromUserWithRole (HttpServletRequest request, Role role) {
		Person person = (Person) request.getSession().getAttribute("user");
		if (person != null && person.getRole().equals(role)) {
			return true;
		}
		return false;
	}

}
