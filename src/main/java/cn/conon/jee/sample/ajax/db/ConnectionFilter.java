package cn.conon.jee.sample.ajax.db;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class ConnectionFilter
 */
public class ConnectionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ConnectionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		Connection connection = null;

		try {
			connection = DBManager.getConnection();
			ConnectionContext.bindTo(connection);

			chain.doFilter(request, response);

			ConnectionContext.remove();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(connection);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
