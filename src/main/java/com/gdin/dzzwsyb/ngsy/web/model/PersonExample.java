package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public PersonExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andSexIsNull() {
			addCriterion("sex is null");
			return (Criteria) this;
		}

		public Criteria andSexIsNotNull() {
			addCriterion("sex is not null");
			return (Criteria) this;
		}

		public Criteria andSexEqualTo(String value) {
			addCriterion("sex =", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotEqualTo(String value) {
			addCriterion("sex <>", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThan(String value) {
			addCriterion("sex >", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexGreaterThanOrEqualTo(String value) {
			addCriterion("sex >=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThan(String value) {
			addCriterion("sex <", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLessThanOrEqualTo(String value) {
			addCriterion("sex <=", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexLike(String value) {
			addCriterion("sex like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotLike(String value) {
			addCriterion("sex not like", value, "sex");
			return (Criteria) this;
		}

		public Criteria andSexIn(List<String> values) {
			addCriterion("sex in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotIn(List<String> values) {
			addCriterion("sex not in", values, "sex");
			return (Criteria) this;
		}

		public Criteria andSexBetween(String value1, String value2) {
			addCriterion("sex between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andSexNotBetween(String value1, String value2) {
			addCriterion("sex not between", value1, value2, "sex");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNull() {
			addCriterion("birthday is null");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNotNull() {
			addCriterion("birthday is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdayEqualTo(Date value) {
			addCriterion("birthday =", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotEqualTo(Date value) {
			addCriterion("birthday <>", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThan(Date value) {
			addCriterion("birthday >", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
			addCriterion("birthday >=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThan(Date value) {
			addCriterion("birthday <", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThanOrEqualTo(Date value) {
			addCriterion("birthday <=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayIn(List<Date> values) {
			addCriterion("birthday in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotIn(List<Date> values) {
			addCriterion("birthday not in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayBetween(Date value1, Date value2) {
			addCriterion("birthday between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotBetween(Date value1, Date value2) {
			addCriterion("birthday not between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andNationalityIsNull() {
			addCriterion("nationality is null");
			return (Criteria) this;
		}

		public Criteria andNationalityIsNotNull() {
			addCriterion("nationality is not null");
			return (Criteria) this;
		}

		public Criteria andNationalityEqualTo(String value) {
			addCriterion("nationality =", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityNotEqualTo(String value) {
			addCriterion("nationality <>", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityGreaterThan(String value) {
			addCriterion("nationality >", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityGreaterThanOrEqualTo(String value) {
			addCriterion("nationality >=", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityLessThan(String value) {
			addCriterion("nationality <", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityLessThanOrEqualTo(String value) {
			addCriterion("nationality <=", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityLike(String value) {
			addCriterion("nationality like", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityNotLike(String value) {
			addCriterion("nationality not like", value, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityIn(List<String> values) {
			addCriterion("nationality in", values, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityNotIn(List<String> values) {
			addCriterion("nationality not in", values, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityBetween(String value1, String value2) {
			addCriterion("nationality between", value1, value2, "nationality");
			return (Criteria) this;
		}

		public Criteria andNationalityNotBetween(String value1, String value2) {
			addCriterion("nationality not between", value1, value2, "nationality");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNull() {
			addCriterion("native_place is null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIsNotNull() {
			addCriterion("native_place is not null");
			return (Criteria) this;
		}

		public Criteria andNativePlaceEqualTo(String value) {
			addCriterion("native_place =", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotEqualTo(String value) {
			addCriterion("native_place <>", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThan(String value) {
			addCriterion("native_place >", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
			addCriterion("native_place >=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThan(String value) {
			addCriterion("native_place <", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLessThanOrEqualTo(String value) {
			addCriterion("native_place <=", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceLike(String value) {
			addCriterion("native_place like", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotLike(String value) {
			addCriterion("native_place not like", value, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceIn(List<String> values) {
			addCriterion("native_place in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotIn(List<String> values) {
			addCriterion("native_place not in", values, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceBetween(String value1, String value2) {
			addCriterion("native_place between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andNativePlaceNotBetween(String value1, String value2) {
			addCriterion("native_place not between", value1, value2, "nativePlace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceIsNull() {
			addCriterion("birthplace is null");
			return (Criteria) this;
		}

		public Criteria andBirthplaceIsNotNull() {
			addCriterion("birthplace is not null");
			return (Criteria) this;
		}

		public Criteria andBirthplaceEqualTo(String value) {
			addCriterion("birthplace =", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceNotEqualTo(String value) {
			addCriterion("birthplace <>", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceGreaterThan(String value) {
			addCriterion("birthplace >", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceGreaterThanOrEqualTo(String value) {
			addCriterion("birthplace >=", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceLessThan(String value) {
			addCriterion("birthplace <", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceLessThanOrEqualTo(String value) {
			addCriterion("birthplace <=", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceLike(String value) {
			addCriterion("birthplace like", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceNotLike(String value) {
			addCriterion("birthplace not like", value, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceIn(List<String> values) {
			addCriterion("birthplace in", values, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceNotIn(List<String> values) {
			addCriterion("birthplace not in", values, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceBetween(String value1, String value2) {
			addCriterion("birthplace between", value1, value2, "birthplace");
			return (Criteria) this;
		}

		public Criteria andBirthplaceNotBetween(String value1, String value2) {
			addCriterion("birthplace not between", value1, value2, "birthplace");
			return (Criteria) this;
		}

		public Criteria andPartyIsNull() {
			addCriterion("party is null");
			return (Criteria) this;
		}

		public Criteria andPartyIsNotNull() {
			addCriterion("party is not null");
			return (Criteria) this;
		}

		public Criteria andPartyEqualTo(String value) {
			addCriterion("party =", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyNotEqualTo(String value) {
			addCriterion("party <>", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyGreaterThan(String value) {
			addCriterion("party >", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyGreaterThanOrEqualTo(String value) {
			addCriterion("party >=", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyLessThan(String value) {
			addCriterion("party <", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyLessThanOrEqualTo(String value) {
			addCriterion("party <=", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyLike(String value) {
			addCriterion("party like", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyNotLike(String value) {
			addCriterion("party not like", value, "party");
			return (Criteria) this;
		}

		public Criteria andPartyIn(List<String> values) {
			addCriterion("party in", values, "party");
			return (Criteria) this;
		}

		public Criteria andPartyNotIn(List<String> values) {
			addCriterion("party not in", values, "party");
			return (Criteria) this;
		}

		public Criteria andPartyBetween(String value1, String value2) {
			addCriterion("party between", value1, value2, "party");
			return (Criteria) this;
		}

		public Criteria andPartyNotBetween(String value1, String value2) {
			addCriterion("party not between", value1, value2, "party");
			return (Criteria) this;
		}

		public Criteria andPartydateIsNull() {
			addCriterion("partydate is null");
			return (Criteria) this;
		}

		public Criteria andPartydateIsNotNull() {
			addCriterion("partydate is not null");
			return (Criteria) this;
		}

		public Criteria andPartydateEqualTo(Date value) {
			addCriterion("partydate =", value, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateNotEqualTo(Date value) {
			addCriterion("partydate <>", value, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateGreaterThan(Date value) {
			addCriterion("partydate >", value, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateGreaterThanOrEqualTo(Date value) {
			addCriterion("partydate >=", value, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateLessThan(Date value) {
			addCriterion("partydate <", value, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateLessThanOrEqualTo(Date value) {
			addCriterion("partydate <=", value, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateIn(List<Date> values) {
			addCriterion("partydate in", values, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateNotIn(List<Date> values) {
			addCriterion("partydate not in", values, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateBetween(Date value1, Date value2) {
			addCriterion("partydate between", value1, value2, "partydate");
			return (Criteria) this;
		}

		public Criteria andPartydateNotBetween(Date value1, Date value2) {
			addCriterion("partydate not between", value1, value2, "partydate");
			return (Criteria) this;
		}

		public Criteria andWorkDateIsNull() {
			addCriterion("work_date is null");
			return (Criteria) this;
		}

		public Criteria andWorkDateIsNotNull() {
			addCriterion("work_date is not null");
			return (Criteria) this;
		}

		public Criteria andWorkDateEqualTo(Date value) {
			addCriterion("work_date =", value, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateNotEqualTo(Date value) {
			addCriterion("work_date <>", value, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateGreaterThan(Date value) {
			addCriterion("work_date >", value, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateGreaterThanOrEqualTo(Date value) {
			addCriterion("work_date >=", value, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateLessThan(Date value) {
			addCriterion("work_date <", value, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateLessThanOrEqualTo(Date value) {
			addCriterion("work_date <=", value, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateIn(List<Date> values) {
			addCriterion("work_date in", values, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateNotIn(List<Date> values) {
			addCriterion("work_date not in", values, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateBetween(Date value1, Date value2) {
			addCriterion("work_date between", value1, value2, "workDate");
			return (Criteria) this;
		}

		public Criteria andWorkDateNotBetween(Date value1, Date value2) {
			addCriterion("work_date not between", value1, value2, "workDate");
			return (Criteria) this;
		}

		public Criteria andHealthIsNull() {
			addCriterion("health is null");
			return (Criteria) this;
		}

		public Criteria andHealthIsNotNull() {
			addCriterion("health is not null");
			return (Criteria) this;
		}

		public Criteria andHealthEqualTo(String value) {
			addCriterion("health =", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthNotEqualTo(String value) {
			addCriterion("health <>", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthGreaterThan(String value) {
			addCriterion("health >", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthGreaterThanOrEqualTo(String value) {
			addCriterion("health >=", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthLessThan(String value) {
			addCriterion("health <", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthLessThanOrEqualTo(String value) {
			addCriterion("health <=", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthLike(String value) {
			addCriterion("health like", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthNotLike(String value) {
			addCriterion("health not like", value, "health");
			return (Criteria) this;
		}

		public Criteria andHealthIn(List<String> values) {
			addCriterion("health in", values, "health");
			return (Criteria) this;
		}

		public Criteria andHealthNotIn(List<String> values) {
			addCriterion("health not in", values, "health");
			return (Criteria) this;
		}

		public Criteria andHealthBetween(String value1, String value2) {
			addCriterion("health between", value1, value2, "health");
			return (Criteria) this;
		}

		public Criteria andHealthNotBetween(String value1, String value2) {
			addCriterion("health not between", value1, value2, "health");
			return (Criteria) this;
		}

		public Criteria andSpecialtyIsNull() {
			addCriterion("specialty is null");
			return (Criteria) this;
		}

		public Criteria andSpecialtyIsNotNull() {
			addCriterion("specialty is not null");
			return (Criteria) this;
		}

		public Criteria andSpecialtyEqualTo(String value) {
			addCriterion("specialty =", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotEqualTo(String value) {
			addCriterion("specialty <>", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyGreaterThan(String value) {
			addCriterion("specialty >", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
			addCriterion("specialty >=", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyLessThan(String value) {
			addCriterion("specialty <", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyLessThanOrEqualTo(String value) {
			addCriterion("specialty <=", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyLike(String value) {
			addCriterion("specialty like", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotLike(String value) {
			addCriterion("specialty not like", value, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyIn(List<String> values) {
			addCriterion("specialty in", values, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotIn(List<String> values) {
			addCriterion("specialty not in", values, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyBetween(String value1, String value2) {
			addCriterion("specialty between", value1, value2, "specialty");
			return (Criteria) this;
		}

		public Criteria andSpecialtyNotBetween(String value1, String value2) {
			addCriterion("specialty not between", value1, value2, "specialty");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNull() {
			addCriterion("id_card is null");
			return (Criteria) this;
		}

		public Criteria andIdCardIsNotNull() {
			addCriterion("id_card is not null");
			return (Criteria) this;
		}

		public Criteria andIdCardEqualTo(String value) {
			addCriterion("id_card =", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotEqualTo(String value) {
			addCriterion("id_card <>", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThan(String value) {
			addCriterion("id_card >", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardGreaterThanOrEqualTo(String value) {
			addCriterion("id_card >=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThan(String value) {
			addCriterion("id_card <", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLessThanOrEqualTo(String value) {
			addCriterion("id_card <=", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardLike(String value) {
			addCriterion("id_card like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotLike(String value) {
			addCriterion("id_card not like", value, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardIn(List<String> values) {
			addCriterion("id_card in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotIn(List<String> values) {
			addCriterion("id_card not in", values, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardBetween(String value1, String value2) {
			addCriterion("id_card between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andIdCardNotBetween(String value1, String value2) {
			addCriterion("id_card not between", value1, value2, "idCard");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuIsNull() {
			addCriterion("xian_ren_zhi_wu is null");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuIsNotNull() {
			addCriterion("xian_ren_zhi_wu is not null");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuEqualTo(String value) {
			addCriterion("xian_ren_zhi_wu =", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuNotEqualTo(String value) {
			addCriterion("xian_ren_zhi_wu <>", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuGreaterThan(String value) {
			addCriterion("xian_ren_zhi_wu >", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuGreaterThanOrEqualTo(String value) {
			addCriterion("xian_ren_zhi_wu >=", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuLessThan(String value) {
			addCriterion("xian_ren_zhi_wu <", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuLessThanOrEqualTo(String value) {
			addCriterion("xian_ren_zhi_wu <=", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuLike(String value) {
			addCriterion("xian_ren_zhi_wu like", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuNotLike(String value) {
			addCriterion("xian_ren_zhi_wu not like", value, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuIn(List<String> values) {
			addCriterion("xian_ren_zhi_wu in", values, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuNotIn(List<String> values) {
			addCriterion("xian_ren_zhi_wu not in", values, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuBetween(String value1, String value2) {
			addCriterion("xian_ren_zhi_wu between", value1, value2, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andXianRenZhiWuNotBetween(String value1, String value2) {
			addCriterion("xian_ren_zhi_wu not between", value1, value2, "xianRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuIsNull() {
			addCriterion("ni_ren_zhi_wu is null");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuIsNotNull() {
			addCriterion("ni_ren_zhi_wu is not null");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuEqualTo(String value) {
			addCriterion("ni_ren_zhi_wu =", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuNotEqualTo(String value) {
			addCriterion("ni_ren_zhi_wu <>", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuGreaterThan(String value) {
			addCriterion("ni_ren_zhi_wu >", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuGreaterThanOrEqualTo(String value) {
			addCriterion("ni_ren_zhi_wu >=", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuLessThan(String value) {
			addCriterion("ni_ren_zhi_wu <", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuLessThanOrEqualTo(String value) {
			addCriterion("ni_ren_zhi_wu <=", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuLike(String value) {
			addCriterion("ni_ren_zhi_wu like", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuNotLike(String value) {
			addCriterion("ni_ren_zhi_wu not like", value, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuIn(List<String> values) {
			addCriterion("ni_ren_zhi_wu in", values, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuNotIn(List<String> values) {
			addCriterion("ni_ren_zhi_wu not in", values, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuBetween(String value1, String value2) {
			addCriterion("ni_ren_zhi_wu between", value1, value2, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiRenZhiWuNotBetween(String value1, String value2) {
			addCriterion("ni_ren_zhi_wu not between", value1, value2, "niRenZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuIsNull() {
			addCriterion("ni_mian_zhi_wu is null");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuIsNotNull() {
			addCriterion("ni_mian_zhi_wu is not null");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuEqualTo(String value) {
			addCriterion("ni_mian_zhi_wu =", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuNotEqualTo(String value) {
			addCriterion("ni_mian_zhi_wu <>", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuGreaterThan(String value) {
			addCriterion("ni_mian_zhi_wu >", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuGreaterThanOrEqualTo(String value) {
			addCriterion("ni_mian_zhi_wu >=", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuLessThan(String value) {
			addCriterion("ni_mian_zhi_wu <", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuLessThanOrEqualTo(String value) {
			addCriterion("ni_mian_zhi_wu <=", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuLike(String value) {
			addCriterion("ni_mian_zhi_wu like", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuNotLike(String value) {
			addCriterion("ni_mian_zhi_wu not like", value, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuIn(List<String> values) {
			addCriterion("ni_mian_zhi_wu in", values, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuNotIn(List<String> values) {
			addCriterion("ni_mian_zhi_wu not in", values, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuBetween(String value1, String value2) {
			addCriterion("ni_mian_zhi_wu between", value1, value2, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andNiMianZhiWuNotBetween(String value1, String value2) {
			addCriterion("ni_mian_zhi_wu not between", value1, value2, "niMianZhiWu");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Integer value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Integer value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Integer value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Integer value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Integer value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Integer> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Integer> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Integer value1, Integer value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Integer value1, Integer value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateIsNull() {
			addCriterion("shuang_shi_date is null");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateIsNotNull() {
			addCriterion("shuang_shi_date is not null");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateEqualTo(Date value) {
			addCriterion("shuang_shi_date =", value, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateNotEqualTo(Date value) {
			addCriterion("shuang_shi_date <>", value, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateGreaterThan(Date value) {
			addCriterion("shuang_shi_date >", value, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateGreaterThanOrEqualTo(Date value) {
			addCriterion("shuang_shi_date >=", value, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateLessThan(Date value) {
			addCriterion("shuang_shi_date <", value, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateLessThanOrEqualTo(Date value) {
			addCriterion("shuang_shi_date <=", value, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateIn(List<Date> values) {
			addCriterion("shuang_shi_date in", values, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateNotIn(List<Date> values) {
			addCriterion("shuang_shi_date not in", values, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateBetween(Date value1, Date value2) {
			addCriterion("shuang_shi_date between", value1, value2, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andShuangShiDateNotBetween(Date value1, Date value2) {
			addCriterion("shuang_shi_date not between", value1, value2, "shuangShiDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateIsNull() {
			addCriterion("enter_date is null");
			return (Criteria) this;
		}

		public Criteria andEnterDateIsNotNull() {
			addCriterion("enter_date is not null");
			return (Criteria) this;
		}

		public Criteria andEnterDateEqualTo(Date value) {
			addCriterion("enter_date =", value, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateNotEqualTo(Date value) {
			addCriterion("enter_date <>", value, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateGreaterThan(Date value) {
			addCriterion("enter_date >", value, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateGreaterThanOrEqualTo(Date value) {
			addCriterion("enter_date >=", value, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateLessThan(Date value) {
			addCriterion("enter_date <", value, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateLessThanOrEqualTo(Date value) {
			addCriterion("enter_date <=", value, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateIn(List<Date> values) {
			addCriterion("enter_date in", values, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateNotIn(List<Date> values) {
			addCriterion("enter_date not in", values, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateBetween(Date value1, Date value2) {
			addCriterion("enter_date between", value1, value2, "enterDate");
			return (Criteria) this;
		}

		public Criteria andEnterDateNotBetween(Date value1, Date value2) {
			addCriterion("enter_date not between", value1, value2, "enterDate");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdIsNull() {
			addCriterion("salary_rank_id is null");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdIsNotNull() {
			addCriterion("salary_rank_id is not null");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdEqualTo(String value) {
			addCriterion("salary_rank_id =", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdNotEqualTo(String value) {
			addCriterion("salary_rank_id <>", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdGreaterThan(String value) {
			addCriterion("salary_rank_id >", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdGreaterThanOrEqualTo(String value) {
			addCriterion("salary_rank_id >=", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdLessThan(String value) {
			addCriterion("salary_rank_id <", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdLessThanOrEqualTo(String value) {
			addCriterion("salary_rank_id <=", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdLike(String value) {
			addCriterion("salary_rank_id like", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdNotLike(String value) {
			addCriterion("salary_rank_id not like", value, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdIn(List<String> values) {
			addCriterion("salary_rank_id in", values, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdNotIn(List<String> values) {
			addCriterion("salary_rank_id not in", values, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdBetween(String value1, String value2) {
			addCriterion("salary_rank_id between", value1, value2, "salaryRankId");
			return (Criteria) this;
		}

		public Criteria andSalaryRankIdNotBetween(String value1, String value2) {
			addCriterion("salary_rank_id not between", value1, value2, "salaryRankId");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}