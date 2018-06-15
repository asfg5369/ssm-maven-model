package com.ssm.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class CommonCodeUtils {
	public static void updateLocal(HttpServletRequest request) {
		String locale = request.getParameter("locale");
		if(locale!=null){
			HttpSession session = request.getSession();
			session.setAttribute("locale", locale);
		}
	}
}
