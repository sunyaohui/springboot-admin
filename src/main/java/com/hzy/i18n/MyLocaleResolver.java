package com.hzy.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

import com.hzy.util.StringUtil;

public class MyLocaleResolver implements LocaleResolver {

	@Override
	public Locale resolveLocale(HttpServletRequest arg0) {
		String l = arg0.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtil.isEmpty(l)) {
            String[] split = l.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
	}

	@Override
	public void setLocale(HttpServletRequest arg0, HttpServletResponse arg1, Locale arg2) {
		// TODO Auto-generated method stub
		
	}

}
