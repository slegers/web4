import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ManageQuoteServlet")
public class ManageQuoteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private QuoteRepository quoteRepository;
	
	public ManageQuoteServlet() {
		super();
		quoteRepository = new QuoteRepository();
	}   	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String quote = quoteRepository.getRandomQuote();
		
		response.getWriter().write(quote);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


}
