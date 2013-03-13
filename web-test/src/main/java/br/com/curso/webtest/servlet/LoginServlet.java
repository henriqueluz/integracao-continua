package br.com.curso.webtest.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.webtest.constant.SegurancaConstant;
import br.com.curso.webtest.service.UsuarioInvalidoException;
import br.com.curso.webtest.service.UsuarioService;

/**
 * Servlet implementation class LoginServlet.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 3167277135634857258L;

	private final UsuarioService usuarioService = UsuarioService.getInstance();

	@Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		try {
			usuarioService.autenticar(email, senha);
			request.getSession().setAttribute(
				SegurancaConstant.USUARIO_AUTENTICADO, email);

			response.sendRedirect("index.jsp");
		} catch (UsuarioInvalidoException e) {
			request.setAttribute("mensagemErro", "Usuario ou senha invalidos!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
    }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}