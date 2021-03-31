package com.mazhar.urlshortner.util;



import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.mazhar.urlshortner.model.ClickEventModel;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.DeviceType;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

public class ClickEvent {

	public static ClickEventModel getClickEvent(HttpServletRequest request) {
//		 final StringBuffer requestURL = request.getRequestURL();
	       
	        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
	        Browser browser = userAgent.getBrowser();
	        String browserName = browser.getName();
	       // Version browserVersion = userAgent.getBrowserVersion();
	        OperatingSystem os = userAgent.getOperatingSystem();
	        DeviceType dt = os.getDeviceType();
            String localAddr = request.getLocalAddr();
           // String protocol = request.getProtocol();
            
            ClickEventModel clickModel = new ClickEventModel(browserName, dt.getName(), localAddr, new Date());
            return clickModel;
        
	}
}
