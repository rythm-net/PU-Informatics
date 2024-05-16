package org.fmi;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Customers
 */
public class Customers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String[] CUSTOMERS = { "Ivan Petrov", "Maria Ivanova", "Dragan Draganov" };

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Content-Type", "text/html");
		
		PrintWriter responseWriter = response.getWriter();

		responseWriter.append("<html><body>Customers:<br><br>");
		String id = request.getParameter("id");
		if (id == null) {
			responseWriter.append("<table>");
			for (int i = 0; i < CUSTOMERS.length; i++) {
				responseWriter.append("<tr><td>" + CUSTOMERS[i] + "</td></tr>");
			}
			responseWriter.append("</table>");
		} else {
			responseWriter.append(CUSTOMERS[Integer.valueOf(id)]);
		}

		responseWriter.append("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
