package br.com.curso.webtest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.webtest.constant.SegurancaConstant;

/**
 * Servlet Filter implementation class SegurancaFilter
 */
@WebFilter({ "*.jsp", "*.srv" })
public class SegurancaFilter implements Filter {

	private static final String PAGINA_LOGIN = "login.jsp";

	/** {@inheritDoc} */
	@Override
	public void destroy() {
	}

	/** {@inheritDoc} */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
	}

	/** {@inheritDoc} */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (isPaginaLogin(httpRequest) || isUsuarioAutenticado(httpRequest)) {
			chain.doFilter(request, response);
		} else {
			redirecionarLogin(response);
		}
	}

	private boolean isPaginaLogin(HttpServletRequest httpRequest) {
		return httpRequest.getServletPath().endsWith(PAGINA_LOGIN);
	}

	private boolean isUsuarioAutenticado(HttpServletRequest httpRequest) {
		Object usuario = httpRequest.getSession().getAttribute(
				SegurancaConstant.USUARIO_AUTENTICADO);
		return usuario != null;
	}

	private void redirecionarLogin(ServletResponse response) throws IOException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		httpResponse.sendRedirect(PAGINA_LOGIN);
	}

}
