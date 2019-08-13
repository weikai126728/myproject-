package com.abbot.schimneylife.util;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpGetNativeUtil {

	/**
	 * 使用Get方式获取数据
	 * 
	 * @param url
	 *            URL包括参数，http://HOST/XX?XX=XX&XXX=XXX
	 * @param charset
	 * @return
	 */
	public static String sendGet(String url) {
		String result = null;
		try {
			// 获取当前客户端对象
			@SuppressWarnings({ "deprecation", "resource" })
			HttpClient httpClient = new DefaultHttpClient();
			// 根据地址获取请求
			HttpGet request = new HttpGet(url);

			request.addHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31");
			String charset = "UTF-8";
			request.setURI(new java.net.URI(url));
			// 通过请求对象获取响应对象
			HttpResponse response = httpClient.execute(request);

			// 判断网络连接状态码是否正常(0--200都数正常)
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				result = EntityUtils.toString(response.getEntity(), charset);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
