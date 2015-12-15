import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/filter/*")
public class Filter implements javax.servlet.Filter {

	private Usuario usuario;
	
	private Usuario getUsuario() throws IOException {
		usuario = new Usuario();
		ClassLoader loader = getClass().getClassLoader();
		InputStream in = loader.getResourceAsStream("login.properties");
		Properties prop = PropertySingleton.singleton().getProp();
		prop.load(in);
		String nome = (String) prop.get("nome");
		String pass = (String) prop.get("pass");
		
		usuario.setNome(nome);
		usuario.setPass(pass);
		
		return usuario;
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String nome = request.getParameter("nome");
		String pass = request.getParameter("senha");
		
		Usuario userParameter = new Usuario();
		userParameter.setNome(nome);
		userParameter.setPass(pass);
		
		//if(isLogged((HttpServletRequest) request)) {
			//((HttpServletResponse) response).sendRedirect("/sitevendas/filter/index.html");
		//}
		if(getUsuario().equals(userParameter)) {
			((HttpServletRequest) request).getSession(false).setAttribute("nome", nome);
			((HttpServletResponse) response).sendRedirect("/sitevendas/filter/index.html");
		} else {
			((HttpServletResponse) response).sendRedirect("/sitevendas/notFound.html");
		}
	}

	public void destroy() {
	}
	
	private boolean isLogged(HttpServletRequest request) {
		String nome = (String) request.getSession(false).getAttribute("nome");
		return nome != null;
	}
	
}
