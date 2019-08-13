package com.abbot.schimneylife.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * 
 * @author Administrator 商户ssl请求post工具栏
 */
public class SslMerchtPostUtil {
	/**
	 * ssl请求post类
	 */
	public String ssl(String url, String data) {
		StringBuffer message = new StringBuffer();
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			// 读取证书路径
			FileInputStream instream = new FileInputStream(new File(ConfigNativeUtil.URL_CERTIFICATE));
			keyStore.load(instream, ConfigNativeUtil.MCH_ID.toCharArray());
			SSLContext sslcontext = SSLContexts.custom()
					.loadKeyMaterial(keyStore, ConfigNativeUtil.MCH_ID.toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			HttpPost httpost = new HttpPost(url);
			httpost.addHeader("Connection", "keep-alive");
			httpost.addHeader("Accept", "*/*");
			httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpost.addHeader("Host", "api.mch.weixin.qq.com");
			httpost.addHeader("X-Requested-With", "XMLHttpRequest");
			httpost.addHeader("Cache-Control", "max-age=0");
			httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
			httpost.setEntity(new StringEntity(data, "UTF-8"));
			CloseableHttpResponse response = httpclient.execute(httpost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent(), "UTF-8"));
					String text;
					while ((text = bufferedReader.readLine()) != null) {
						message.append(text);
					}
				}
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				response.close();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return message.toString();
	}
	public String sslredpack(String url, String data) {
		StringBuffer message = new StringBuffer();
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			// 读取证书路径
			FileInputStream instream = new FileInputStream(new File(ConfigureUtil.URL_CERTIFICATE_CERT.toString()));
			keyStore.load(instream, ConfigureUtil.MCH_ID.toString().toCharArray());
			SSLContext sslcontext = SSLContexts.custom()
					.loadKeyMaterial(keyStore, ConfigureUtil.MCH_ID.toString().toCharArray()).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			HttpPost httpost = new HttpPost(url);
			
			httpost.addHeader("Connection", "keep-alive");
			httpost.addHeader("Accept", "*/*");
			httpost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			httpost.addHeader("Host", "api.mch.weixin.qq.com");
			httpost.addHeader("X-Requested-With", "XMLHttpRequest");
			httpost.addHeader("Cache-Control", "max-age=0");
			httpost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
			httpost.setEntity(new StringEntity(data, "UTF-8"));
			CloseableHttpResponse response = httpclient.execute(httpost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent(), "UTF-8"));
					String text;
					while ((text = bufferedReader.readLine()) != null) {
						message.append(text);
					}
				}
				EntityUtils.consume(entity);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				response.close();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return message.toString();
	}
}
