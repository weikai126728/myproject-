package com.abbot.schimneylife.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.abbot.schimneylife.util.ConfigureUtil;
import com.abbot.schimneylife.util.HttpRequestUtil;
import com.abbot.schimneylife.util.ImageUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@RequestMapping("/image")
@Controller
public class ImageController extends BaseController{
	Logger logger = Logger.getLogger(ImageController.class);
	/**
	 * 
	 * @param type
	 * @param image
	 * @param source  请求来源 0是移动端
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/showImage")
	public void showImage(Integer type,String image,HttpServletResponse response,HttpServletRequest request) throws IOException {
		OutputStream out = null;
		InputStream in = null;
		BufferedImage tag = null;
		boolean source = HttpRequestUtil.isMobile(request);
		try {
			String path = "";
			if(type==null) {
				path =ConfigureUtil.PRODUCT_IMAGE.toString();				
			}else if(type==1) {
				path = ConfigureUtil.PRODUCT_EVALUATE.toString();
				
			}
			path += image.replace("_", "/");
			out = response.getOutputStream();
			response.setContentType("image/*"); //图片
			File file = new File(path);
			if(image==null||image.isEmpty()||!file.exists()) {//如果不存在则获取默认图片
				source = false;
				in = request.getServletContext().getResourceAsStream("image/common/404.jpg");
			}else if(source){//对移动端图片请求进行压缩
				BufferedImage src = javax.imageio.ImageIO.read(file); 
				long length = file.length();
				if(length>80*1024) {//超过80kb进行压缩
					int widthdist = src.getWidth(null); // 得到源图宽  
					int heightdist = src.getHeight(null); // 得到源图高  ;
					if (widthdist == 0 || heightdist == 0) {  
						return;  
					} else {  
						widthdist = (int) (widthdist * 0.5);  
						heightdist = (int) (heightdist * 0.5);  
					}  
					// 开始读取文件并进行压缩  
					tag = new BufferedImage((int) widthdist,  
							(int) heightdist, BufferedImage.TYPE_INT_RGB);  
					
					tag.getGraphics().drawImage(  
							src.getScaledInstance(widthdist, heightdist,  
									Image.SCALE_SMOOTH), 0, 0, null);  					
				}else {
					in = new FileInputStream(file);
					source = false;
				}
			}else{
				in = new FileInputStream(file);
			}
		} catch (IOException e) {
			logger.error("image="+image,e);
		}finally {
			try {
				if(source) {
					String formatName = image.substring(image.indexOf(".")+1, image.length());
					ImageIO.write(tag, formatName, out);
				}else {
					byte[] data = new byte[0];
					if(in!=null) {
						int size = in.available();
						data = new byte[size];
						in.read(data);
						in.close();
					}
					if(out!=null) {
						out.write(data);
					}		
				}
				out.flush();
				out.close(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		}
	}
	
	@RequestMapping("/upload")
	public void upload(@RequestParam("files") MultipartFile[] files) {
		StringBuffer sb = new StringBuffer();
		JSONArray array = new JSONArray();
		for(MultipartFile file:files) {
			String path = ImageUtil.writeFile(file, ConfigureUtil.PRODUCT_IMAGE.toString());
			array.add(path);
		}
		JSONObject object = new JSONObject();
		object.put("errno", 0);
		object.put("data", array);
		System.out.println(object);
		this.writeJSON(object.toJSONString());
	}
	@RequestMapping("/showvideo")
	public void showvideo(String image ,HttpServletResponse response,HttpServletRequest request) throws IOException {
		//String path="E:/upload/WeChat_20181030173015.mp4";
		try{
			String path =ConfigureUtil.PRODUCT_IMAGE.toString();				
			path += image.replace("_", "/");
            FileInputStream fis = new FileInputStream(path); // 以byte流的方式打开文件
            int i=fis.available(); //得到文件大小
            byte data[]=new byte[i];
            fis.read(data);  //读数据
            response.setContentType("video/*"); //设置返回的文件类型
            OutputStream toClient=response.getOutputStream(); //得到向客户端输出二进制数据的对象
            toClient.write(data);  //输出数据
            toClient.flush();
            toClient.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("文件不存在");
        }


	}
}
