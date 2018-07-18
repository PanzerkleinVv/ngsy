package com.gdin.dzzwsyb.ngsy.web.model;

public class PeopleExtends extends Person{
	private String technical_title;//专业职称
	
	private String resume;//简历
	
	private String ageSelect;
	
	private String enterDateSelect;
	
	private String ageInt;
	
	private String enterDateInt;
	
	public PeopleExtends() {};
	
	public PeopleExtends(Person person) {
		super(person);
	}
	
	public PeopleExtends(PeopleExtends peopleExtends) {
		this((Person)peopleExtends);
		technical_title = peopleExtends.getTechnical_title();
		resume = peopleExtends.getResume();
		ageSelect = peopleExtends.getAgeSelect();
		enterDateSelect = peopleExtends.getEnterDateSelect();
		ageInt = peopleExtends.getAgeInt();
		enterDateInt = peopleExtends.getEnterDateInt();
	}

	public String getTechnical_title() {
		return technical_title;
	}

	public void setTechnical_title(String technical_title) {
		this.technical_title = technical_title;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getAgeSelect() {
		return ageSelect;
	}

	public void setAgeSelect(String ageSelect) {
		this.ageSelect = ageSelect;
	}

	public String getEnterDateSelect() {
		return enterDateSelect;
	}

	public void setEnterDateSelect(String enterDateSelect) {
		this.enterDateSelect = enterDateSelect;
	}

	public String getAgeInt() {
		return ageInt;
	}

	public void setAgeInt(String ageInt) {
		this.ageInt = ageInt;
	}

	public String getEnterDateInt() {
		return enterDateInt;
	}

	public void setEnterDateInt(String enterDateInt) {
		this.enterDateInt = enterDateInt;
	}
	
	
	
}
