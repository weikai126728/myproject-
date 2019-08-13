package com.abbot.schimneylife.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static final String IMAGE_TYPE = "jpg/png/ico";//允许上传的图片类型
	public static String writeFile(MultipartFile file,String path) {
		Calendar calendar = Calendar.getInstance();
		String absPath = calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"
		+calendar.get(Calendar.DAY_OF_MONTH);
		path += absPath;
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		String old = file.getOriginalFilename();
		int idex = old.lastIndexOf(".");
		String type = old.substring(idex+1);
		/*if(!ImageUtil.IMAGE_TYPE.contains(type)) {
			return "";
		}*/
		String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+type;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+newName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (absPath+"/"+newName).replaceAll("/", "_");
	}
	public static String writeDistributionFile(MultipartFile file,String path) {
		Calendar calendar = Calendar.getInstance();
		String absPath = calendar.get(Calendar.YEAR)+""+(calendar.get(Calendar.MONTH)+1)+""+calendar.get(Calendar.DAY_OF_MONTH);
		path += "upload/"+absPath;
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		String old = file.getOriginalFilename();
		int idex = old.lastIndexOf(".");
		String type = old.substring(idex+1);
		/*if(!ImageUtil.IMAGE_TYPE.contains(type)) {
			return "";
		}*/
		String newName = UUID.randomUUID().toString().replaceAll("-", "")+"."+type;
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path+"/"+newName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "upload/"+absPath.replaceAll("/", "_")+"/"+newName;
	}
}
