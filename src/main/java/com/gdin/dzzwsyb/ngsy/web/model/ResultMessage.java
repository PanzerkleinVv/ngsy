package com.gdin.dzzwsyb.ngsy.web.model;

import com.gdin.dzzwsyb.ngsy.web.enums.MessageColor;

public class ResultMessage {
	
	private String methodInfo;
	
	private String resultInfo;
	
	private String msg;
	
	private String color;
	
	public void setMsg() {
		this.msg = methodInfo + resultInfo;
	}

	public String getMsg() {
		this.msg = methodInfo + resultInfo;
		return msg;
	}

	public String getMethodInfo() {
		return methodInfo;
	}

	public void setMethodInfo(String methodInfo) {
		this.methodInfo = methodInfo;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public ResultMessage edit() {
		this.methodInfo = "修改";
		return this;
	}
	
	public ResultMessage delete() {
		this.methodInfo = "删除";
		return this;
	}
	
	public ResultMessage add() {
		this.methodInfo = "新增";
		return this;
	}
	
	public ResultMessage get() {
		this.methodInfo = "查询";
		return this;
	}
	
	public ResultMessage success() {
		this.resultInfo = "成功！";
		this.color = MessageColor.SUCCESS.getColor();
		return this;
	}
	
	public ResultMessage failure() {
		this.resultInfo = "失败！";
		this.color = MessageColor.FAILURE.getColor();
		return this;
	}

}