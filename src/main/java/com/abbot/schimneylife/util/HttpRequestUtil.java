package com.abbot.schimneylife.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

public class HttpRequestUtil {

	/**
	 * 判断是否来自手机访问
	 * @param request
	 * @return
	 */
	public static boolean isMobile(HttpServletRequest request) {
		
		boolean isMoblie = false;  
        String[] mobileAgents = { "iphone", "android", "phone", "mobile", "wap", 
        		"netfront", "java", "opera mobi","opera mini","ucweb", "ucbrowser", "windows ce", 
        		"symbian", "series", "webos", "sony", "blackberry", "dopod",  "nokia", 
        		"samsung", "palmsource", "xda", "pieplus", "meizu", "midp", "cldc", 
        		"motorola", "foma", "docomo", "up.browser", "up.link", "blazer", "helio", 
        		"hosin", "huawei", "novarra", "coolpad", "webos",  "techfaith", "palmsource", 
        		"alcatel", "amoi", "ktouch", "nexian","ericsson", "philips", "sagem",
        		"wellcom", "bunjalloo", "maui","smartphone", "iemobile", "spice", "bird", 
        		"zte-", "longcos","pantech", "gionee", "portalmmm", "jig browser", "hiptop", 
        		"benq", "haier", "^lct", "320x320", "240x320", "176x220", "w3c ", "acs-", 
        		"alav", "alca", "amoi", "audi", "avan", "benq", "bird", "blac","blaz", 
        		"brew", "cell", "cldc", "cmd-", "dang", "doco", "eric", "hipt", "inno", 
        		"ipaq", "java", "jigs","kddi", "keji", "leno", "lg-c", "lg-d", "lg-g", 
        		"lge-", "maui", "maxo", "midp", "mits", "mmef", "mobi","mot-", "moto", 
        		"mwbp", "nec-", "newt", "noki", "oper", "palm", "pana", "pant", "phil", 
        		"play", "port","prox", "qwap", "sage", "sams", "sany", "sch-", "sec-", 
        		"send", "seri", "sgh-", "shar", "sie-", "siem","smal", "smar", "sony", 
        		"sph-", "symb", "t-mo", "teli", "tim-", "tosh", "tsm-", "upg1", "upsi", 
        		"vk-v","voda", "wap-", "wapa", "wapi", "wapp", "wapr", "webc", "winw", 
        		"winw", "xda", "xda-","Googlebot-Mobile" };  
        if (request.getHeader("User-Agent") != null) {  
            for (String mobileAgent : mobileAgents) {
                if (request.getHeader("User-Agent").toLowerCase().indexOf(mobileAgent) >= 0) {  
                    isMoblie = true;  
                    break;  
                }  
            }  
        }
		return isMoblie;
	}
	public static JSONObject sendPost(String url,Map<String,String> data,String last) {
		 PrintWriter out = null;
	        BufferedReader in = null;
	        String result = "";
	        String param = "";
	        if(data!=null) {
	        	String g = "";
	        	Iterator<String> keys = data.keySet().iterator();
	        	while(keys.hasNext()) {
	        		param +=g;
	        		g="&";
	        		String key = keys.next();
	        		param += key+"="+data.get(key);
	        	}
	        }
	        if(last!=null) {
	        	param += last;
	        }
	        try {
	            URL realUrl = new URL(url);
	            // 打开和URL之间的连接
	            URLConnection conn = realUrl.openConnection();
	            // 设置通用的请求属性
	            conn.setRequestProperty("accept", "*/*");
	            conn.setRequestProperty("connection", "Keep-Alive");
	            conn.setRequestProperty("user-agent",
	                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	            // 发送POST请求必须设置如下两行
	            conn.setDoOutput(true);
	            conn.setDoInput(true);
	            // 获取URLConnection对象对应的输出流
	            out = new PrintWriter(conn.getOutputStream());
	            // 发送请求参数
	            out.print(param);
	            // flush输出流的缓冲
	            out.flush();
	            // 定义BufferedReader输入流来读取URL的响应
	            in = new BufferedReader(
	                    new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = in.readLine()) != null) {
	                result += line;
	            }
	        } catch (Exception e) {
	            System.out.println("发送 POST 请求出现异常！"+e);
	            e.printStackTrace();
	        }
	        //使用finally块来关闭输出流、输入流
	        finally{
	            try{
	                if(out!=null){
	                    out.close();
	                }
	                if(in!=null){
	                    in.close();
	                }
	            }
	            catch(IOException ex){
	                ex.printStackTrace();
	            }
	        }
	        return JSONObject.parseObject(result);
	    }  
	public static JSONObject sendPost(String url,String data) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(data);
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！"+e);
			e.printStackTrace();
		}
		//使用finally块来关闭输出流、输入流
		finally{
			try{
				if(out!=null){
					out.close();
				}
				if(in!=null){
					in.close();
				}
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		return JSONObject.parseObject(result);
	}  
	public static boolean sendMessage(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String,String> data = new HashMap<>();
		data.put("message", message);
		String key = Md5Util.createSalt();
		String salt = Md5Util.createSalt();
		String signature = Md5Util.encodeByMod5(key, salt);
		data.put("key", key);
		data.put("salt", salt);
		data.put("signature", signature);
		JSONObject obj = HttpRequestUtil.sendPost(ConfigureUtil.MALLURL.toString(), data, null);
		return obj.getBoolean("result");
	}
	public static JSONObject sendFile(String url,String filePath,String name) throws IOException {
		URL u = new URL(url);
		HttpURLConnection con = (HttpURLConnection) u.openConnection();

	       con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式

	       con.setDoInput(true);

	       con.setDoOutput(true);

	       con.setUseCaches(false); // post方式不能使用缓存

	       // 设置请求头信息

	       con.setRequestProperty("Connection", "Keep-Alive");

	       con.setRequestProperty("Charset", "UTF-8");

	       // 设置边界

	       String BOUNDARY = "----------" + System.currentTimeMillis();

	       con.setRequestProperty("Content-Type", "multipart/form-data; boundary="

	               + BOUNDARY);

	       // 请求正文信息

	       // 第一部分：
	       File file = new File(filePath);

	       if (!file.exists() || !file.isFile()) {

	           throw new IOException("上传的文件不存在");

	       }
	       StringBuilder sb = new StringBuilder();

	       sb.append("--"); // 必须多两道线

	       sb.append(BOUNDARY);

	       sb.append("\r\n");
	       if(name==null||"".equals(name.trim())) {
	    	   sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
	    			   + file.getName() +"\"\r\n");	    	   
	       }else {
	    	   sb.append("Content-Disposition: form-data;name=\""+name+"\";filename=\""
	    			   + file.getName() +"\"\r\n");	    
	       }

	       sb.append("Content-Type:application/octet-stream\r\n\r\n");

	       byte[] head = sb.toString().getBytes("utf-8");

	       // 获得输出流

	       OutputStream out = new DataOutputStream(con.getOutputStream());

	       // 输出表头

	       out.write(head);

	       // 文件正文部分

	       // 把文件已流文件的方式 推入到url中

	       DataInputStream in = new DataInputStream(new FileInputStream(file));
	       int bytes = 0;
	       byte[] bufferOut = new byte[1024];
	       while ((bytes = in.read(bufferOut)) != -1) {
	           out.write(bufferOut, 0, bytes);
	       }
	       in.close();
	       // 结尾部分
	       byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
	       out.write(foot);
	       out.flush();
	       out.close();
	       StringBuffer buffer = new StringBuffer();
	       BufferedReader reader = null;
	       String result = null;
	       try {
	           // 定义BufferedReader输入流来读取URL的响应
	           reader = new BufferedReader(new InputStreamReader(con

	                   .getInputStream()));

	           String line = null;

	           while ((line = reader.readLine()) != null) {
	               buffer.append(line);
	           }
	           if (result == null) {
	               result = buffer.toString();
	           }
	       } catch (IOException e) {
	           System.out.println("发送POST请求出现异常！" + e);
	           e.printStackTrace();
	           throw new IOException("数据读取异常");
	       } finally {
	           if (reader != null) {
	               reader.close();
	           }
	       }
	       JSONObject jsonObj =JSONObject.parseObject(result);
	       return jsonObj;
	}
	public static JSONObject sendFile1(String url,MultipartFile file) throws IOException {
		URL u = new URL(url);
		HttpURLConnection con = (HttpURLConnection) u.openConnection();
		
		con.setRequestMethod("POST"); // 以Post方式提交表单，默认get方式
		
		con.setDoInput(true);
		
		con.setDoOutput(true);
		
		con.setUseCaches(false); // post方式不能使用缓存
		
		// 设置请求头信息
		
		con.setRequestProperty("Connection", "Keep-Alive");
		
		con.setRequestProperty("Charset", "UTF-8");
		
		// 设置边界
		
		String BOUNDARY = "----------" + System.currentTimeMillis();
		
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary="
				
	               + BOUNDARY);
		
		// 请求正文信息
		
		// 第一部分：
		StringBuilder sb = new StringBuilder();
		
		sb.append("--"); // 必须多两道线
		
		sb.append(BOUNDARY);
		
		sb.append("\r\n");
		
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\""
				
	               + file.getName() + "\"\r\n");
		
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		
		byte[] head = sb.toString().getBytes("utf-8");
		
		// 获得输出流
		
		OutputStream out = new DataOutputStream(con.getOutputStream());
		
		// 输出表头
		
		out.write(head);
		
		// 文件正文部分
		
		// 把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(file.getInputStream());
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();
		// 结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
		out.write(foot);
		out.flush();
		out.close();
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			// 定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con
					
					.getInputStream()));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
			throw new IOException("数据读取异常");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		JSONObject jsonObj =JSONObject.parseObject(result);
		return jsonObj;
	}
	
	
	 public static void uploadFile(String uri,String fileName) {  
	        try {  
	  
	            // 换行符  
	            final String newLine = "\r\n";  
	            final String boundaryPrefix = "--";  
	            // 定义数据分隔线  
	            String BOUNDARY = "========7d4a6d158c9";  
	            // 服务器的域名  
	            URL url = new URL(uri);  
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
	            // 设置为POST情  
	            conn.setRequestMethod("POST");  
	            // 发送POST请求必须设置如下两行  
	            conn.setDoOutput(true);  
	            conn.setDoInput(true);  
	            conn.setUseCaches(false);  
	            // 设置请求头参数  
	            conn.setRequestProperty("connection", "Keep-Alive");  
	            conn.setRequestProperty("Charsert", "UTF-8");  
	            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);  
	  
	            OutputStream out = new DataOutputStream(conn.getOutputStream());  
	  
	            // 上传文件  
	            File file = new File(fileName);  
	            StringBuilder sb = new StringBuilder();  
	            sb.append(boundaryPrefix);  
	            sb.append(BOUNDARY);  
	            sb.append(newLine);  
	            // 文件参数,photo参数名可以随意修改  
	            sb.append("Content-Disposition: form-data;name=\"media\";filename=\"" + fileName  
	                    + "\"" + newLine);  
	            sb.append("Content-Type:application/octet-stream");  
	            // 参数头设置完以后需要两个换行，然后才是参数内容  
	            sb.append(newLine);  
	            sb.append(newLine);  
	  
	            // 将参数头的数据写入到输出流中  
	            out.write(sb.toString().getBytes());  
	  
	            // 数据输入流,用于读取文件数据  
	            DataInputStream in = new DataInputStream(new FileInputStream(  
	                    file));  
	            byte[] bufferOut = new byte[1024];  
	            int bytes = 0;  
	            // 每次读1KB数据,并且将文件数据写入到输出流中  
	            while ((bytes = in.read(bufferOut)) != -1) {  
	                out.write(bufferOut, 0, bytes);  
	            }  
	            // 最后添加换行  
	            out.write(newLine.getBytes());  
	            in.close();  
	  
	            // 定义最后数据分隔线，即--加上BOUNDARY再加上--。  
	            byte[] end_data = (newLine + boundaryPrefix + BOUNDARY + boundaryPrefix + newLine)  
	                    .getBytes();  
	            // 写上结尾标识  
	            out.write(end_data);  
	            out.flush();  
	            out.close();  
	  
	            // 定义BufferedReader输入流来读取URL的响应  
	            BufferedReader reader = new BufferedReader(new InputStreamReader(  
	                    conn.getInputStream()));  
	            String line = null;  
	            while ((line = reader.readLine()) != null) {  
	                System.out.println(line);  
	            }  
	  
	        } catch (Exception e) {  
	            System.out.println("发送POST请求出现异常！" + e);  
	            e.printStackTrace();  
	        }  
	    }  
}
