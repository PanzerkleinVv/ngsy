package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobPersonExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public JobPersonExample() {
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

		public Criteria andJobIdIsNull() {
			addCriterion("job_id is null");
			return (Criteria) this;
		}

		public Criteria andJobIdIsNotNull() {
			addCriterion("job_id is not null");
			return (Criteria) this;
		}

		public Criteria andJobIdEqualTo(String value) {
			addCriterion("job_id =", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotEqualTo(String value) {
			addCriterion("job_id <>", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdGreaterThan(String value) {
			addCriterion("job_id >", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdGreaterThanOrEqualTo(String value) {
			addCriterion("job_id >=", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLessThan(String value) {
			addCriterion("job_id <", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLessThanOrEqualTo(String value) {
			addCriterion("job_id <=", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdLike(String value) {
			addCriterion("job_id like", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotLike(String value) {
			addCriterion("job_id not like", value, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdIn(List<String> values) {
			addCriterion("job_id in", values, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotIn(List<String> values) {
			addCriterion("job_id not in", values, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdBetween(String value1, String value2) {
			addCriterion("job_id between", value1, value2, "jobId");
			return (Criteria) this;
		}

		public Criteria andJobIdNotBetween(String value1, String value2) {
			addCriterion("job_id not between", value1, value2, "jobId");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoIsNull() {
			addCriterion("shuang_jian_tiao is null");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoIsNotNull() {
			addCriterion("shuang_jian_tiao is not null");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoEqualTo(String value) {
			addCriterion("shuang_jian_tiao =", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoNotEqualTo(String value) {
			addCriterion("shuang_jian_tiao <>", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoGreaterThan(String value) {
			addCriterion("shuang_jian_tiao >", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoGreaterThanOrEqualTo(String value) {
			addCriterion("shuang_jian_tiao >=", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoLessThan(String value) {
			addCriterion("shuang_jian_tiao <", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoLessThanOrEqualTo(String value) {
			addCriterion("shuang_jian_tiao <=", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoLike(String value) {
			addCriterion("shuang_jian_tiao like", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoNotLike(String value) {
			addCriterion("shuang_jian_tiao not like", value, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoIn(List<String> values) {
			addCriterion("shuang_jian_tiao in", values, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoNotIn(List<String> values) {
			addCriterion("shuang_jian_tiao not in", values, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoBetween(String value1, String value2) {
			addCriterion("shuang_jian_tiao between", value1, value2, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andShuangJianTiaoNotBetween(String value1, String value2) {
			addCriterion("shuang_jian_tiao not between", value1, value2, "shuangJianTiao");
			return (Criteria) this;
		}

		public Criteria andJobSalaryIsNull() {
			addCriterion("job_salary is null");
			return (Criteria) this;
		}

		public Criteria andJobSalaryIsNotNull() {
			addCriterion("job_salary is not null");
			return (Criteria) this;
		}

		public Criteria andJobSalaryEqualTo(String value) {
			addCriterion("job_salary =", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryNotEqualTo(String value) {
			addCriterion("job_salary <>", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryGreaterThan(String value) {
			addCriterion("job_salary >", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryGreaterThanOrEqualTo(String value) {
			addCriterion("job_salary >=", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryLessThan(String value) {
			addCriterion("job_salary <", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryLessThanOrEqualTo(String value) {
			addCriterion("job_salary <=", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryLike(String value) {
			addCriterion("job_salary like", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryNotLike(String value) {
			addCriterion("job_salary not like", value, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryIn(List<String> values) {
			addCriterion("job_salary in", values, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryNotIn(List<String> values) {
			addCriterion("job_salary not in", values, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryBetween(String value1, String value2) {
			addCriterion("job_salary between", value1, value2, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andJobSalaryNotBetween(String value1, String value2) {
			addCriterion("job_salary not between", value1, value2, "jobSalary");
			return (Criteria) this;
		}

		public Criteria andSalaryIsNull() {
			addCriterion("salary is null");
			return (Criteria) this;
		}

		public Criteria andSalaryIsNotNull() {
			addCriterion("salary is not null");
			return (Criteria) this;
		}

		public Criteria andSalaryEqualTo(Long value) {
			addCriterion("salary =", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryNotEqualTo(Long value) {
			addCriterion("salary <>", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryGreaterThan(Long value) {
			addCriterion("salary >", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryGreaterThanOrEqualTo(Long value) {
			addCriterion("salary >=", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryLessThan(Long value) {
			addCriterion("salary <", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryLessThanOrEqualTo(Long value) {
			addCriterion("salary <=", value, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryIn(List<Long> values) {
			addCriterion("salary in", values, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryNotIn(List<Long> values) {
			addCriterion("salary not in", values, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryBetween(Long value1, Long value2) {
			addCriterion("salary between", value1, value2, "salary");
			return (Criteria) this;
		}

		public Criteria andSalaryNotBetween(Long value1, Long value2) {
			addCriterion("salary not between", value1, value2, "salary");
			return (Criteria) this;
		}

		public Criteria andOwnDateIsNull() {
			addCriterion("own_date is null");
			return (Criteria) this;
		}

		public Criteria andOwnDateIsNotNull() {
			addCriterion("own_date is not null");
			return (Criteria) this;
		}

		public Criteria andOwnDateEqualTo(Date value) {
			addCriterion("own_date =", value, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateNotEqualTo(Date value) {
			addCriterion("own_date <>", value, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateGreaterThan(Date value) {
			addCriterion("own_date >", value, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateGreaterThanOrEqualTo(Date value) {
			addCriterion("own_date >=", value, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateLessThan(Date value) {
			addCriterion("own_date <", value, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateLessThanOrEqualTo(Date value) {
			addCriterion("own_date <=", value, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateIn(List<Date> values) {
			addCriterion("own_date in", values, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateNotIn(List<Date> values) {
			addCriterion("own_date not in", values, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateBetween(Date value1, Date value2) {
			addCriterion("own_date between", value1, value2, "ownDate");
			return (Criteria) this;
		}

		public Criteria andOwnDateNotBetween(Date value1, Date value2) {
			addCriterion("own_date not between", value1, value2, "ownDate");
			return (Criteria) this;
		}

		public Criteria andIsProbationIsNull() {
			addCriterion("is_probation is null");
			return (Criteria) this;
		}

		public Criteria andIsProbationIsNotNull() {
			addCriterion("is_probation is not null");
			return (Criteria) this;
		}

		public Criteria andIsProbationEqualTo(String value) {
			addCriterion("is_probation =", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationNotEqualTo(String value) {
			addCriterion("is_probation <>", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationGreaterThan(String value) {
			addCriterion("is_probation >", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationGreaterThanOrEqualTo(String value) {
			addCriterion("is_probation >=", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationLessThan(String value) {
			addCriterion("is_probation <", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationLessThanOrEqualTo(String value) {
			addCriterion("is_probation <=", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationLike(String value) {
			addCriterion("is_probation like", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationNotLike(String value) {
			addCriterion("is_probation not like", value, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationIn(List<String> values) {
			addCriterion("is_probation in", values, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationNotIn(List<String> values) {
			addCriterion("is_probation not in", values, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationBetween(String value1, String value2) {
			addCriterion("is_probation between", value1, value2, "isProbation");
			return (Criteria) this;
		}

		public Criteria andIsProbationNotBetween(String value1, String value2) {
			addCriterion("is_probation not between", value1, value2, "isProbation");
			return (Criteria) this;
		}

		public Criteria andProbationDateIsNull() {
			addCriterion("probation_date is null");
			return (Criteria) this;
		}

		public Criteria andProbationDateIsNotNull() {
			addCriterion("probation_date is not null");
			return (Criteria) this;
		}

		public Criteria andProbationDateEqualTo(Date value) {
			addCriterion("probation_date =", value, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateNotEqualTo(Date value) {
			addCriterion("probation_date <>", value, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateGreaterThan(Date value) {
			addCriterion("probation_date >", value, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateGreaterThanOrEqualTo(Date value) {
			addCriterion("probation_date >=", value, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateLessThan(Date value) {
			addCriterion("probation_date <", value, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateLessThanOrEqualTo(Date value) {
			addCriterion("probation_date <=", value, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateIn(List<Date> values) {
			addCriterion("probation_date in", values, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateNotIn(List<Date> values) {
			addCriterion("probation_date not in", values, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateBetween(Date value1, Date value2) {
			addCriterion("probation_date between", value1, value2, "probationDate");
			return (Criteria) this;
		}

		public Criteria andProbationDateNotBetween(Date value1, Date value2) {
			addCriterion("probation_date not between", value1, value2, "probationDate");
			return (Criteria) this;
		}

		public Criteria andLostDateIsNull() {
			addCriterion("lost_date is null");
			return (Criteria) this;
		}

		public Criteria andLostDateIsNotNull() {
			addCriterion("lost_date is not null");
			return (Criteria) this;
		}

		public Criteria andLostDateEqualTo(Date value) {
			addCriterion("lost_date =", value, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateNotEqualTo(Date value) {
			addCriterion("lost_date <>", value, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateGreaterThan(Date value) {
			addCriterion("lost_date >", value, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateGreaterThanOrEqualTo(Date value) {
			addCriterion("lost_date >=", value, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateLessThan(Date value) {
			addCriterion("lost_date <", value, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateLessThanOrEqualTo(Date value) {
			addCriterion("lost_date <=", value, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateIn(List<Date> values) {
			addCriterion("lost_date in", values, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateNotIn(List<Date> values) {
			addCriterion("lost_date not in", values, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateBetween(Date value1, Date value2) {
			addCriterion("lost_date between", value1, value2, "lostDate");
			return (Criteria) this;
		}

		public Criteria andLostDateNotBetween(Date value1, Date value2) {
			addCriterion("lost_date not between", value1, value2, "lostDate");
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