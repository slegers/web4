package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ChatService;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ChatService model;
	private ControllerFactory controllerFactory = new ControllerFactory();

	public Controller() {
		super();
		model = ChatService.getChatService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String destination = "index.jsp";
        request.setAttribute("blogs",model.getBlogs());
		RequestHandler handler = null;
        if (action != null) {

        	try {
        		handler = controllerFactory.getController(action, model);
				destination = handler.handleRequest(request, response);
        	}
        	catch (NotAuthorizedException exc) {
        		List<String> errors = new ArrayList<String>();
        		errors.add(exc.getMessage());
        		request.setAttribute("errors", errors);
        		destination="index.jsp";
        	}
        }
        if (handler == null || handler instanceof SynHandler) {
			RequestDispatcher view = request.getRequestDispatcher(destination);
			view.forward(request, response);
		}
		else {
        	response.setHeader("Access-Control-Allow-Origin","*");
        	response.getWriter().write(destination);
		}
	}

}
