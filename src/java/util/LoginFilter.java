package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {
	
	private List<String> urlExceptList = new ArrayList<String>();

    /**
     * Default constructor. 
     */
    public LoginFilter() {
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
		// TODO Auto-generated method stub
		// place your code here
		if( canNext(request)){
			chain.doFilter(request, response);
		}else{
			request.setAttribute("message", "please login first." );
			request.getRequestDispatcher("/common/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		urlExceptList.add("/loginAction");
		urlExceptList.add("/registerAction");
		urlExceptList.add("/register.jsp");
		urlExceptList.add("/login.jsp");
	}
	
	Boolean canNext( ServletRequest request ){
		HttpServletRequest hsr = (HttpServletRequest) request;
		String uri = hsr.getRequestURI();
		
		
		uri = uri.substring(uri.lastIndexOf("/") );
		int index = uri.indexOf("jsessionid");
		
		if( index>0 ){
			uri = uri.substring(0, index-1 );
		}
		if( urlExceptList.contains(uri) ){
			return true;
		}
		String userName = (String) hsr.getSession().getAttribute("userName");
		if( userName ==null || userName.equals("")){
			return false;
		}
		return true;
	}
	
}
