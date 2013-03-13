package br.com.curso.webtest.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.webtest.model.Usuario;
import br.com.curso.webtest.service.UsuarioService;

/**
 * Servlet implementation class UsuarioServlet.
 */
@WebServlet("/usuario.srv")
public class UsuarioServlet extends HttpServlet {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = -3162419944663739724L;

	private final UsuarioService usuarioService = UsuarioService.getInstance();

	@Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	List<Usuario> usuarios = usuarioService.listar();
    	request.setAttribute("usuarios", usuarios);

    	request.getRequestDispatcher("usuarios.jsp").forward(request, response);
    }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}