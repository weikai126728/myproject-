package com.abbot.schimneylife.util.tag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.abbot.schimneylife.pojo.user.Authority;
import com.abbot.schimneylife.pojo.user.User;
import com.abbot.schimneylife.service.user.AuthorityService;
import com.abbot.schimneylife.util.CommonKey;
import com.abbot.schimneylife.util.SessionManager;

public class AuthorityTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer no;

	public void setNo(Integer no) {
		this.no = no;
	}
	
	@Override
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
		ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.pageContext.getServletContext());
		AuthorityService authorityService = ac.getBean(AuthorityService.class);
		if(SessionManager.contains(request, SessionManager.Key.USER)) {
			User user = SessionManager.getAttribute(request, SessionManager.Key.USER);
			List<Authority> list = authorityService.findByRole(user.getRole().getId());
			if(user.getRole().getLevel()==CommonKey.Role.SUPERMANAGER.getLevel()) {
				return Tag.EVAL_BODY_INCLUDE;
			}
			if(list==null||list.size()==0) {
				return Tag.SKIP_BODY;
			}
			for(Authority a:list) {
				if(this.no.equals(a.getOrder())) {
					return Tag.EVAL_BODY_INCLUDE;
				}
			}
			return Tag.SKIP_BODY;
		}else {
			return Tag.SKIP_BODY;
		}
	}

	
}
