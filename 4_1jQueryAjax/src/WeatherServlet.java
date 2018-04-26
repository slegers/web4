import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

@WebServlet("/WeatherServlet")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WeatherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String city = request.getParameter("cityName");
		String report = getWeather(city);
		response.setContentType("text/plain");
		response.getWriter().write("" + report + "");
	}

	private String getWeather(String city) {
		String report;

		if (city.toLowerCase().equals("leuven"))
			report = "Currently it is not raining in Leuven. Average temperature is 20";
		else if (city.toLowerCase().equals("hove"))
			report = "It's a rainy season in Hove now. Better get a umbrella before going out.";
		else if (city.toLowerCase().equals("zonhoven"))
			report = "It's very cloudy in Zonhoven.";
		else
			report = "The City you have entered is not present in our system. May be it has been destroyed "
					+ "in last World War or not yet built by the mankind";
		return report;
	}

}
