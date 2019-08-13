package com.abbot.schimneylife.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.abbot.schimneylife.pojo.shopping.CustomerEvaluate;

public class Evaluates {

	private List<CustomerEvaluate> evaluateList;
	private List<MultipartFile[]> fileList;
	public List<CustomerEvaluate> getEvaluateList() {
		return evaluateList;
	}
	public void setEvaluateList(List<CustomerEvaluate> evaluateList) {
		this.evaluateList = evaluateList;
	}
	public List<MultipartFile[]> getFileList() {
		return fileList;
	}
	public void setFileList(List<MultipartFile[]> fileList) {
		this.fileList = fileList;
	}
	
}
