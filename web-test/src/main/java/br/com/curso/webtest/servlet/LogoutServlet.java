package br.com.curso.webtest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 5781090078707040573L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getSession().invalidate();
		response.sendRedirect("login.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}