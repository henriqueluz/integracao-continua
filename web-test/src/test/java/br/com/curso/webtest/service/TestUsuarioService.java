package br.com.curso.webtest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import br.com.curso.webtest.model.Usuario;

public class TestUsuarioService {

	private final UsuarioService usuarioService = UsuarioService.getInstance();

	@Test
	public void testListar() {
		List<Usuario> usuarios = usuarioService.listar();
		assertEquals(4, usuarios.size());
		for (Usuario usuario : usuarios) {
			assertEquals("teste13", usuario.getSenha());
			assertEquals(usuario.getNome().toLowerCase()
					+ "@gmail.com", usuario.getEmail());
		}
	}

	@Test
	public void testAutenticar() {
		try {
			usuarioService.autenticar("fabio@gmail.com", "teste123");
		} catch (UsuarioInvalidoException e) {
			fail("Usuario ou senha invalidos");
		}
	}

	@Test(expected = UsuarioInvalidoException.class)
	public void testAutenticarException() throws UsuarioInvalidoException {
		usuarioService.autenticar("fabio@gmail.com", "teste321");
	}

}
