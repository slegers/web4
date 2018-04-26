import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/QuoteServlet")
public class QuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuoteRepository quoteRepository;
		
	public QuoteServlet() {
		super();
		quoteRepository = new QuoteRepository();
	}   	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String json = "";
		if (action.equals("random")) {
			Quote quote = quoteRepository.getRandomQuote();
			json = this.quoteToJSON(quote);
		}
		else if (action.equals("overview")){
			json = this.quotesToJSON(quoteRepository.getAll());
		}
		response.setContentType("application/json");
		response.getWriter().write(json);
	}
		
	public String quoteToJSON (Quote quote) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(quote);
	}

	public String quotesToJSON (List<Quote> quotes) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(quotes);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
