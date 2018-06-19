package com.gdin.dzzwsyb.ngsy.web.model;

public class PeopleExtends extends Person{
	private String technical_title;//专业职称
	
	private String resume;//简历
	
	public PeopleExtends() {};
	
	public PeopleExtends(Person person) {
		super(person);
	}
	
	public PeopleExtends(PeopleExtends peopleExtends) {
		this((Person)peopleExtends);
		technical_title = peopleExtends.getTechnical_title();
		resume = peopleExtends.getResume();
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
	
	
}
