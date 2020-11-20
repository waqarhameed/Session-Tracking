package repeatvisitor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RepeatVisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("html/text");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>cookie example</h2>");
		String msg = "";
		boolean repeatVisitor = false;

		Cookie[] cookies = request.getCookies();

		if (cookies == null) {

			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];

				String name = c.getName();
				String value = c.getValue();
				if (name.equals("repeat") && value.equals("yes")) {
					msg = "Welcome Back";
					repeatVisitor = true;
					break;
				}
			}
			if (repeatVisitor == false) {
				Cookie c1 = new Cookie("repeat", "yes");
				c1.setMaxAge(60);
				response.addCookie(c1);
				msg = "Welcome Aboard";
			}

			out.println("<h2>" + msg + "</h2>");
			out.println("<body>");
			out.println("<html>");

		}
	}

}