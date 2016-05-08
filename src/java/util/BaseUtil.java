package util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class BaseUtil {
	public static void main(String[] args) {
		System.out.println(BaseUtil.getUUID());
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static boolean stringNotEmpty(String string) {
		return !stringEmpty(string);
	}

	public static boolean stringEmpty(String string) {
		if (string == null) {
			return true;
		}
		if (string.trim().equals("")) {
			return true;
		}
		return false;
	}

	public static String getUserNameFromSession(HttpServletRequest request) {
		String userName = (String) request.getSession()
				.getAttribute("userName");
		return userName;
	}
}
