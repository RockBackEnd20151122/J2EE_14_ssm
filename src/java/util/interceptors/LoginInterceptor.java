package util.interceptors;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import util.BaseUtil;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	private List<String> exceptUriList = new ArrayList<String>();

	public LoginInterceptor() {
		exceptUriList.add("/loginAction.action");
		exceptUriList.add("/addUserAction.action");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("adfadfasdf");

		HttpServletRequest request = (HttpServletRequest) arg0
				.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		String uri = getRequestUri(request);
		String userName = BaseUtil.getUserNameFromSession(request);

		if (this.judgeIsLogin(uri, userName)) {
			return arg0.invoke();
		} else {
			return "login";
		}
	}

	private String getRequestUri(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int index = uri.indexOf("jsessionid");
		if (index > 0) {
			uri = uri.substring(0, index - 1);
		}
		uri = uri.substring(uri.lastIndexOf("/"));
		return uri;
	}

	private boolean judgeIsLogin(String uri, String userName) {
		if (this.exceptUriList.contains(uri)) {
			return true;
		}
		if (userName == null || "".equals(userName)) {
			return false;
		}
		return true;
	}

}
