/**
 * 
 */
package com.mazhar.urlshortner.util;

import java.util.LinkedHashMap;

/**
 * @author Mazhar Ibna Zahur
 *
 *Mar 26, 2021 1:29:55 AM
 */
public class AppResponse {

	private static LinkedHashMap<String, Object> responseModel = new LinkedHashMap<>();

	public static Object resourceNotFound(String message) {
		responseModel.put("status", Boolean.FALSE);
		responseModel.put("message", message);
		return responseModel;
	}

	public static Object resourceCreated() {
		responseModel.put("status", Boolean.TRUE);
		responseModel.put("message", "Resource created successfully!");
		return responseModel;
	}

	public static Object operationFail(String message) {
		responseModel.put("status", Boolean.FALSE);
		responseModel.put("message", message);
		return responseModel;
	}

	public static Object operationFail() {
		responseModel.put("status", Boolean.FALSE);
		responseModel.put("message", "Operation fail to execute");
		return responseModel;
	}

	public static Object operationSuccess() {
		responseModel.put("status", Boolean.TRUE);
		responseModel.put("messages", "Operation successfully executed!");
		return responseModel;
	}

}
