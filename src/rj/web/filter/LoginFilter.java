package rj.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	private FilterConfig config;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		String path = ((HttpServletRequest) req).getServletPath();

		String suffix = "." + path.split("\\.")[1];

		config.getServletContext().setAttribute("suffix", suffix);

		if (!"1".equals(((HttpServletRequest) req).getSession().getAttribute(
				"IS_LOGIN"))) {
			((HttpServletResponse) resp).sendRedirect(config
					.getServletContext().getContextPath()
					+ "/Login"
					+ config.getServletContext().getAttribute("suffix"));

			return;
		}

		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {

	}
}
