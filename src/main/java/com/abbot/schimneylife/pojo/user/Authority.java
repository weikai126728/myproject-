package com.abbot.schimneylife.pojo.user;

import java.util.List;

/**
 * 权限
 * @author Administrator
 *
 */
public class Authority {

	private Integer id;
	private Integer pid;
	private String name;
	private String describe;
	private Integer order;
	private String uri;
	private String author;
	private String createTime;
	private List<Authority> children;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public List<Authority> getChildren() {
		return children;
	}
	public void setChildren(List<Authority> children) {
		this.children = children;
	}
	
}
