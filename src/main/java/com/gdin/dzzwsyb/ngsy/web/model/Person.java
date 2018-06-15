package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {
	private String id;

	private String name;

	private String sex;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String nationality;

	private String nativePlace;

	private String birthplace;

	private String party;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date partydate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workDate;

	private String health;

	private String specialty;

	private String idCard;

	private String xianRenZhiWu;

	private String niRenZhiWu;

	private String niMianZhiWu;

	private Integer state;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shuangShiDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date enterDate;

	private String type;

	private String salaryRankId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality == null ? null : nationality.trim();
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace == null ? null : nativePlace.trim();
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace == null ? null : birthplace.trim();
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party == null ? null : party.trim();
	}

	public Date getPartydate() {
		return partydate;
	}

	public void setPartydate(Date partydate) {
		this.partydate = partydate;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health == null ? null : health.trim();
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty == null ? null : specialty.trim();
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard == null ? null : idCard.trim();
	}

	public String getXianRenZhiWu() {
		return xianRenZhiWu;
	}

	public void setXianRenZhiWu(String xianRenZhiWu) {
		this.xianRenZhiWu = xianRenZhiWu == null ? null : xianRenZhiWu.trim();
	}

	public String getNiRenZhiWu() {
		return niRenZhiWu;
	}

	public void setNiRenZhiWu(String niRenZhiWu) {
		this.niRenZhiWu = niRenZhiWu == null ? null : niRenZhiWu.trim();
	}

	public String getNiMianZhiWu() {
		return niMianZhiWu;
	}

	public void setNiMianZhiWu(String niMianZhiWu) {
		this.niMianZhiWu = niMianZhiWu == null ? null : niMianZhiWu.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getShuangShiDate() {
		return shuangShiDate;
	}

	public void setShuangShiDate(Date shuangShiDate) {
		this.shuangShiDate = shuangShiDate;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getSalaryRankId() {
		return salaryRankId;
	}

	public void setSalaryRankId(String salaryRankId) {
		this.salaryRankId = salaryRankId == null ? null : salaryRankId.trim();
	}
}