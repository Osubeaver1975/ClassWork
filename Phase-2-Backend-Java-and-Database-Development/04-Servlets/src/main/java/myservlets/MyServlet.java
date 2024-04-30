package myservlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MyServlet
 * 
 * A servlet is a process that runs on a server to handle http requests
 * ... from the browser
 * It recieves a request, dynamically generate an HTML page and
 * ... send it back to the browser
 * It tells the server what url path it will handle - @WebServlet("url-path")
 * 
 * 							servername:port/ProjectName		/ URL path
 * the path to the servlet: localhost:8081/04-MyFirstServlet/frank
 * 
 *  A URL may also contain query parameters: ?parameterName=value&anotherParameter=another value
 * 
 * 
 * Servlet methods that handle http requests:
 * 
 * 		GET request is handled by the doGet() method (retrieve info from server)
 *  	POST request is handled by the doPost() method (add info to the server data store)
 * 		PUT request is handled by the doPut() method (Update info on the server data store)
 *  	DELETE request is handled by the doDelete() method (delete info from server data store)
 * 		Whenever a URL is entered in the browser, it generatesan HTTP GET request
 * 
 *  	Anything other than an HTTP GET comes from some program/ process
 */

@WebServlet("/frank") // this identifies the URL path this servlet will handle

public class MyServlet extends HttpServlet {	// Servlets are subclasses of Httpservlet class
	private static final long serialVersionUID = 1L;
       
    
	
	
	/**
     * @see HttpServlet#HttpServlet()
     * 
     * Constructor for this servlet
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Handle HTTP GET requests from the browser
	 * 
	 * 
	 * 
	 * This method will also handle a query parameter called "yourName"
	 * 
	 *  localhost:8081/04-MyFirst-Servlet/frank?yourName=someValue
	 * 
	 * 
	 * Whenever a URL is entered in the browser, it generatesan HTTP GET request
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * Every servlet method receives two params:
	 * ... an HttpServletRequest - Contains info about what browser wants
	 * ... an HttpServletResponse - Contains whatever we want sent back to browser
	 * ... in most cases that is the dynamic html we want to display
	 */
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// We need to create HTML to send back to the browser in the response object we are given
    	//
    	//The response object contain an object we can use to write the HTML into the response
    		
    		//Instantiate a PrintWriter object initialized to the writer object in the response
    	// Use the printWriter object to write HTML into the response
    	
    	//PrintWriter allows us to use the same methods as System.out	
    	
    	PrintWriter htmlWriter = response.getWriter();
    	
    	// Get the 'yourName' query param out of the URL and into a variable
    	String theName = request.getParameter("yourName");
    	
    	// Write an <h1> tag to the response writer object
    	htmlWriter.println("<h1>Welcome to My First Servlet! ! ! </h1>");
    	
    	htmlWriter.println("<p>I see your name is: " + theName + "</p>");
    	
    	htmlWriter.close(); 	// Close the PrintWriter to be sure all lines make it 
    						// ... out of the buffer and into the response
    	// This one here does a direct write using the response writer object
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
