package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.List;

public class DutiesPersonExtendList {
	private List<DutiesPersonExtend> DutiesPersonExtends;

	public DutiesPersonExtendList(List<DutiesPersonExtend> DutiesPersonExtends) {
		super();
		this.DutiesPersonExtends = DutiesPersonExtends;
	}

	public DutiesPersonExtendList() {
		super();
	}

	public List<DutiesPersonExtend> getDutiesPersonExtends() {
		return DutiesPersonExtends;
	}

	public void setDutiesPersonExtends(List<DutiesPersonExtend> dutiesPersonExtends) {
		DutiesPersonExtends = dutiesPersonExtends;
	}

	
	
	

}
