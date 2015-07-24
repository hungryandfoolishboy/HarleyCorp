package com.alibaba.dingtalk.openapi.demo.auth;

import com.alibaba.dingtalk.openapi.demo.Env;
import com.alibaba.dingtalk.openapi.demo.OApiException;
import com.alibaba.dingtalk.openapi.demo.OApiResultException;
import com.alibaba.dingtalk.openapi.demo.utils.HttpHelper;
import com.alibaba.fastjson.JSONObject;

public class AuthHelper {

	public static String getAccessToken() throws OApiException {
		String url = Env.OAPI_HOST + "/gettoken?" + 
				"corpid=" + Env.CORP_ID + "&corpsecret=" + Env.SECRET;
		JSONObject response = HttpHelper.httpGet(url);
		if (response.containsKey("access_token")) {
			return response.getString("access_token");
		}
		else {
			throw new OApiResultException("access_token");
		}
	}
	
	public static String getJsapiTicket(String accessToken) throws OApiException {
		String url = Env.OAPI_HOST + "/get_jsapi_ticket?" + 
				"type=jsapi" + "&access_token=" + accessToken;
		JSONObject response = HttpHelper.httpGet(url);
		if (response.containsKey("ticket")) {
			return response.getString("ticket");
		}
		else {
			throw new OApiResultException("ticket");
		}
	}
}
