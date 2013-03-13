package br.com.curso.webtest.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.curso.webtest.model.Usuario;

public class UsuarioService implements Serializable {

	/**
	 * Serial Version UID.
	 */
	private static final long serialVersionUID = 2109939600926854321L;

	private static UsuarioService instance = new UsuarioService();

	public static UsuarioService getInstance() {
		return instance;
	}

	private List<Usuario> usuarios;

	private UsuarioService() {
		usuarios = new ArrayList<Usuario>(5);
		usuarios.add(new Usuario("Fabio", "fabio@gmail.com", "teste123"));
		usuarios.add(new Usuario("Maria", "maria@gmail.com", "teste123"));
		usuarios.add(new Usuario("Jose", "jose@gmail.com", "teste123"));
		usuarios.add(new Usuario("Pedro", "pedro@gmail.com", "teste123"));
		usuarios.add(new Usuario("Ana", "ana@gmail.com", "teste123"));
	}

	public List<Usuario> listar() {
		return usuarios;
	}

	public void autenticar(String email, String senha)
			throws UsuarioInvalidoException {
		if (email != null && senha != null) {
			for (Usuario usuario : usuarios) {
				if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
					return;
				}
			}
		}
		
		throw new UsuarioInvalidoException();
	}
}
