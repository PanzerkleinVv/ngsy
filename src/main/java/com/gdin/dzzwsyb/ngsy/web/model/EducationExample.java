package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EducationExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public EducationExample() {
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

		public Criteria andPersonIdIsNull() {
			addCriterion("person_id is null");
			return (Criteria) this;
		}

		public Criteria andPersonIdIsNotNull() {
			addCriterion("person_id is not null");
			return (Criteria) this;
		}

		public Criteria andPersonIdEqualTo(String value) {
			addCriterion("person_id =", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdNotEqualTo(String value) {
			addCriterion("person_id <>", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdGreaterThan(String value) {
			addCriterion("person_id >", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
			addCriterion("person_id >=", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdLessThan(String value) {
			addCriterion("person_id <", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdLessThanOrEqualTo(String value) {
			addCriterion("person_id <=", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdLike(String value) {
			addCriterion("person_id like", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdNotLike(String value) {
			addCriterion("person_id not like", value, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdIn(List<String> values) {
			addCriterion("person_id in", values, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdNotIn(List<String> values) {
			addCriterion("person_id not in", values, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdBetween(String value1, String value2) {
			addCriterion("person_id between", value1, value2, "personId");
			return (Criteria) this;
		}

		public Criteria andPersonIdNotBetween(String value1, String value2) {
			addCriterion("person_id not between", value1, value2, "personId");
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

		public Criteria andSchoolIsNull() {
			addCriterion("school is null");
			return (Criteria) this;
		}

		public Criteria andSchoolIsNotNull() {
			addCriterion("school is not null");
			return (Criteria) this;
		}

		public Criteria andSchoolEqualTo(String value) {
			addCriterion("school =", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolNotEqualTo(String value) {
			addCriterion("school <>", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolGreaterThan(String value) {
			addCriterion("school >", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolGreaterThanOrEqualTo(String value) {
			addCriterion("school >=", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolLessThan(String value) {
			addCriterion("school <", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolLessThanOrEqualTo(String value) {
			addCriterion("school <=", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolLike(String value) {
			addCriterion("school like", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolNotLike(String value) {
			addCriterion("school not like", value, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolIn(List<String> values) {
			addCriterion("school in", values, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolNotIn(List<String> values) {
			addCriterion("school not in", values, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolBetween(String value1, String value2) {
			addCriterion("school between", value1, value2, "school");
			return (Criteria) this;
		}

		public Criteria andSchoolNotBetween(String value1, String value2) {
			addCriterion("school not between", value1, value2, "school");
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

		public Criteria andEducationIsNull() {
			addCriterion("education is null");
			return (Criteria) this;
		}

		public Criteria andEducationIsNotNull() {
			addCriterion("education is not null");
			return (Criteria) this;
		}

		public Criteria andEducationEqualTo(String value) {
			addCriterion("education =", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotEqualTo(String value) {
			addCriterion("education <>", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationGreaterThan(String value) {
			addCriterion("education >", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationGreaterThanOrEqualTo(String value) {
			addCriterion("education >=", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationLessThan(String value) {
			addCriterion("education <", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationLessThanOrEqualTo(String value) {
			addCriterion("education <=", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationLike(String value) {
			addCriterion("education like", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotLike(String value) {
			addCriterion("education not like", value, "education");
			return (Criteria) this;
		}

		public Criteria andEducationIn(List<String> values) {
			addCriterion("education in", values, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotIn(List<String> values) {
			addCriterion("education not in", values, "education");
			return (Criteria) this;
		}

		public Criteria andEducationBetween(String value1, String value2) {
			addCriterion("education between", value1, value2, "education");
			return (Criteria) this;
		}

		public Criteria andEducationNotBetween(String value1, String value2) {
			addCriterion("education not between", value1, value2, "education");
			return (Criteria) this;
		}

		public Criteria andDegreeIsNull() {
			addCriterion("degree is null");
			return (Criteria) this;
		}

		public Criteria andDegreeIsNotNull() {
			addCriterion("degree is not null");
			return (Criteria) this;
		}

		public Criteria andDegreeEqualTo(String value) {
			addCriterion("degree =", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotEqualTo(String value) {
			addCriterion("degree <>", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeGreaterThan(String value) {
			addCriterion("degree >", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeGreaterThanOrEqualTo(String value) {
			addCriterion("degree >=", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeLessThan(String value) {
			addCriterion("degree <", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeLessThanOrEqualTo(String value) {
			addCriterion("degree <=", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeLike(String value) {
			addCriterion("degree like", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotLike(String value) {
			addCriterion("degree not like", value, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeIn(List<String> values) {
			addCriterion("degree in", values, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotIn(List<String> values) {
			addCriterion("degree not in", values, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeBetween(String value1, String value2) {
			addCriterion("degree between", value1, value2, "degree");
			return (Criteria) this;
		}

		public Criteria andDegreeNotBetween(String value1, String value2) {
			addCriterion("degree not between", value1, value2, "degree");
			return (Criteria) this;
		}

		public Criteria andGraduationDateIsNull() {
			addCriterion("graduation_date is null");
			return (Criteria) this;
		}

		public Criteria andGraduationDateIsNotNull() {
			addCriterion("graduation_date is not null");
			return (Criteria) this;
		}

		public Criteria andGraduationDateEqualTo(Date value) {
			addCriterion("graduation_date =", value, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateNotEqualTo(Date value) {
			addCriterion("graduation_date <>", value, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateGreaterThan(Date value) {
			addCriterion("graduation_date >", value, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateGreaterThanOrEqualTo(Date value) {
			addCriterion("graduation_date >=", value, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateLessThan(Date value) {
			addCriterion("graduation_date <", value, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateLessThanOrEqualTo(Date value) {
			addCriterion("graduation_date <=", value, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateIn(List<Date> values) {
			addCriterion("graduation_date in", values, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateNotIn(List<Date> values) {
			addCriterion("graduation_date not in", values, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateBetween(Date value1, Date value2) {
			addCriterion("graduation_date between", value1, value2, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andGraduationDateNotBetween(Date value1, Date value2) {
			addCriterion("graduation_date not between", value1, value2, "graduationDate");
			return (Criteria) this;
		}

		public Criteria andIsHighestIsNull() {
			addCriterion("is_highest is null");
			return (Criteria) this;
		}

		public Criteria andIsHighestIsNotNull() {
			addCriterion("is_highest is not null");
			return (Criteria) this;
		}

		public Criteria andIsHighestEqualTo(String value) {
			addCriterion("is_highest =", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestNotEqualTo(String value) {
			addCriterion("is_highest <>", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestGreaterThan(String value) {
			addCriterion("is_highest >", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestGreaterThanOrEqualTo(String value) {
			addCriterion("is_highest >=", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestLessThan(String value) {
			addCriterion("is_highest <", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestLessThanOrEqualTo(String value) {
			addCriterion("is_highest <=", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestLike(String value) {
			addCriterion("is_highest like", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestNotLike(String value) {
			addCriterion("is_highest not like", value, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestIn(List<String> values) {
			addCriterion("is_highest in", values, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestNotIn(List<String> values) {
			addCriterion("is_highest not in", values, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestBetween(String value1, String value2) {
			addCriterion("is_highest between", value1, value2, "isHighest");
			return (Criteria) this;
		}

		public Criteria andIsHighestNotBetween(String value1, String value2) {
			addCriterion("is_highest not between", value1, value2, "isHighest");
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