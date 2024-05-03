package gamblerservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gambler.Gambler;
import gambler.GamblerDao;
import gambler.MemoryGamblerDao;

/**
 * Servlet implementation class GamblerServlet
 */
@WebServlet("/gambler")
public class GamblerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private GamblerDao gamblerTable;

	/**
	 * @throws IOException
	 * @see HttpServlet#HttpServlet()
	 */
	public GamblerServlet() throws IOException {
		super();
		gamblerTable = new MemoryGamblerDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	// this method is run when doGet  servlet for this path is run
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

// Instantiate a PrintWriter to write HTML into the response
// Note: We get the PrintWriter from the response
// 		because the response knows how it wants the HTML written to it
		PrintWriter htmlWriter = response.getWriter();
		
// Retrieve any query parameters from the URL path
		// these are names in the <input tag of the for in the JSP
		String idRequested          = request.getParameter("id");
		String gamblerNameRequested = request.getParameter("gamblerName");
		String id2Update            = request.getParameter("id2Update");
		String id2Delete            = request.getParameter("id2Delete");
		
// these statements are for debugging purposes
		//they will display what was in the query parameters in the console
		//System.out.println("id requested: " + idRequested);
		//System.out.println("name requested: " + gamblerNameRequested);
		//System.out.println("id to delete: " + id2Update);
		//System.out.println("id to update: " + id2Delete);
		
		// Define the object to be hold andy Gamblers retrieved fromt he data source
		// ... it may contain 0 to many Gamblers That is why he makes it a list 
		// ... in case it is more than 1 gambler
	
		List<Gambler> theGamblers = new ArrayList();
	
// Determine the processing based on the query parameters passed to the servlet
		// if no query params are passed - get ALL gamblers
		if(idRequested == null
		&& gamblerNameRequested == null
		&& id2Delete == null
		&& id2Update == null) {							// get all gamblers from data source
		   theGamblers = gamblerTable.getAllGamblers();	// using the DAO method to do so
		}
		
// if the id of Gambler to be displayed was passed as a query param 
		if(idRequested != null) {		// use the DAO method to get the Gambler with that id
				theGamblers.add(gamblerTable.findGamblerById(Integer.parseInt(idRequested)));
		}	
		
// if the name of the Gambler to be displayed was passed as a queory 
		if(idRequested == null ) {	// ... Use the DAO method to get the Gambler whose name contains the value		   
		   theGamblers = gamblerTable.findGamblerByName(gamblerNameRequested); //and add it to the list holding the Gamblers
		}
		if(theGamblers.size() == 0) {
			htmlWriter.println("<h1>No Gamblers Found!</h1>");
			
			htmlWriter.println("<div>");
			htmlWriter.println("<a href=\"./HomePage.jsp\">Return to Home Page</a>");
			htmlWriter.println("</div>");
		}
		

		for(Gambler aGambler : theGamblers) {
			
	
			htmlWriter.println("<title>Gambler Info</title>");
			htmlWriter.println("<link rel=\"stylesheet\" href=\"./resources/style.css\"></link>");
	try {		
	// write the HTML to provide a title on the page - using data from the current Gambler -->
			htmlWriter.println("<h2>Gambler Information for Gambler Id: " + aGambler.getId() + "</h2>");
			
			
	// Write the HTML to show all the info for the current Gambler
			htmlWriter.println("<div class=aGambler>");
			htmlWriter.println("<p>Name: " + aGambler.getName() + "</p>");
			htmlWriter.println("<p>Address: " + aGambler.getAddress() + "</p>");
			htmlWriter.println("<p>Birth Date: " + aGambler.getBirthDate() + "</p>");
			htmlWriter.println("<p>Monthly Salary: " + aGambler.getMonthlySalary() + "</p>");
			htmlWriter.println("</div>");
	} // End of try block
	catch(NullPointerException excpetionBlock) {
		htmlWriter.println("<h1>Gambler Id: " + idRequested + "  not found!</h1>");
	}
	// Write the HTML to provide a link back to the Home Page
			htmlWriter.println("<div>");
			htmlWriter.println("<a href=\"./HomePage.jsp\">Return to Home Page</a>");
			htmlWriter.println("</div>");
		}

	// Write a footer line on the page showing when the data was retrieved 
	// Note: use of the writer in the response (not required)
		response.getWriter().append("Data as of: " + (LocalDateTime.now().toString().replace("T"," "))+ "\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
