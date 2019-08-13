package com.abbot.schimneylife.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.abbot.schimneylife.util.CommonKey;
import com.alibaba.fastjson.JSONObject;

public abstract class BaseController {

	protected static final Integer PAGESIZE = 5;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;

	@ModelAttribute
	protected void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.session = request.getSession();
	}

	protected void writeJSON(String jsonString) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(jsonString);
			out.flush();
		} catch (IOException e) {
			
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	protected void writeExcel(HSSFWorkbook wb,String fileName) {
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition", "attachment; filename="+fileName+".xls");
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			wb.write(response.getOutputStream());
			out.flush();
		} catch (IOException e) {
			
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	protected void writeXML(String xml) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(xml);
			out.flush();
		} catch (IOException e) {
			
		} finally {
			if (out != null&& !out.checkError()) {
				out.close();
			}
		}
	}

	/**
	 * 计算总页数
	 * 
	 * @return
	 */
	protected Integer countTotalPage(Integer totalResult, Integer pageSize) {
		if (totalResult % pageSize == 0) {
			return totalResult / pageSize;
		}
		return totalResult / pageSize + 1;
	}

	/**
	 * 封装统一的json返回格式
	 * 
	 * @param code
	 *            0通信成功 1异常 2 session过期
	 * @param jsonResult
	 * @return
	 */
	protected JSONObject createJSONResult(Integer code, String jsonResult) {
		JSONObject object = new JSONObject();
		object.put("code", code);
		object.put("result", jsonResult);
		return object;
	}
	/**
	 * 封装统一的json返回格式
	 * 
	 * @param code
	 *            0通信成功 1异常 2 session过期
	 * @param jsonResult
	 * @return
	 */
	protected JSONObject createJSONResult(Integer code, Object jsonResult) {
		JSONObject object = new JSONObject();
		object.put("code", code);
		object.put("result", jsonResult);
		return object;
	}

	/**
	 * 瀑布流刷新使用，刨去初始页数据
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	protected Integer countFirstResultForHome(Integer currentPage, Integer pageSize) {
		if (currentPage == 0) {
			return 0;
		}
		return currentPage * pageSize - pageSize + CommonKey.WAP_PAGESIZE;
	}

	/**
	 * 瀑布流刷新使用，刨去初始页数据
	 * 
	 * @param total
	 * @param pageSize
	 * @return
	 */
	protected Integer countTotalPageForHome(Integer total, Integer pageSize) {
		return this.countTotalPage(total - CommonKey.WAP_PAGESIZE + pageSize, pageSize);
	}

	protected boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
