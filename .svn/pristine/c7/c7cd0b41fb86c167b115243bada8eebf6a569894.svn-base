package com.abbot.schimneylife.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import com.alibaba.ocean.rawsdk.util.SignatureUtil;

public class AlibabaRequestUtil {
	private static final String rootPath = "https://gw.open.1688.com/openapi/";
	public static String request(String namespace,String method,Map<String,Object> parameters) {
		String requestUrl = "param2/1/"+namespace+"/"+method+"/"+ConfigureUtil.ALIBABA_APPKEY.toString();
		String outputStr = "";
		Iterator<String> iterator = parameters.keySet().iterator(); 
		String y = "";
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value=parameters.get(key).toString();
			outputStr += y+key+"="+value;
			y="&";
		}
		byte[] bb = SignatureUtil.hmacSha1(requestUrl, parameters, ConfigureUtil.ALIBABA_SECKEY.toString());
		outputStr+="&_aop_signature="+SignatureUtil.encodeHexStr(bb);
		System.out.println(outputStr);
		StringBuffer buffer=null;  
	        try{  
	        URL url=new URL(rootPath+requestUrl);  
	        HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
	        conn.setDoOutput(true);  
	        conn.setDoInput(true);  
	        conn.setRequestMethod("POST");  
	        conn.connect();  
	        //往服务器端写内容 也就是发起http请求需要带的参数  
	        if(null!=outputStr){  
	            OutputStream os=conn.getOutputStream();  
	            os.write(outputStr.getBytes("utf-8"));  
	            os.close();  
	        }  
	        int httpCode = conn.getResponseCode();
	        InputStream is = null;
	        if((httpCode >= 200) && (httpCode <= 299)) {
	        	//读取服务器端返回的内容  
		        is=conn.getInputStream();  
		        
	        }else {
	        	is = conn.getErrorStream();
	        }
	        InputStreamReader isr=new InputStreamReader(is,"utf-8");  
	        BufferedReader br=new BufferedReader(isr);  
	        buffer=new StringBuffer();  
	        String line=null;  
	        while((line=br.readLine())!=null){  
	            buffer.append(line);  
	        }  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
	    System.out.println(buffer.toString());
        return buffer.toString();  
	}
}
