package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.gdin.dzzwsyb.ngsy.web.model.VLogExample.Criteria;

public class LogQuery {
	private String content;
	
	private String type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date beginDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	private int pageNo;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setExample(Criteria criteria) {
		if (content != null && !"".equals(content)) {
			criteria.andContentLike("%" + content + "%");
		}
		if (type != null && !"".equals(type)) {
			criteria.andTypeEqualTo(type);
		}
		if (beginDate != null) {
			criteria.andTimeGreaterThanOrEqualTo(beginDate);
		}
		if (endDate != null) {
			criteria.andTimeLessThanOrEqualTo(endDate);
		}
		if (pageNo == 0) {
			pageNo = 1;
		}
		criteria.andIdIsNotNull();
	}
}
