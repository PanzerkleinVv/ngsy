package com.gdin.dzzwsyb.ngsy.web.model;

import java.util.ArrayList;
import java.util.List;

public class SalaryRankExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public SalaryRankExample() {
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

		public Criteria andRankIsNull() {
			addCriterion("rank is null");
			return (Criteria) this;
		}

		public Criteria andRankIsNotNull() {
			addCriterion("rank is not null");
			return (Criteria) this;
		}

		public Criteria andRankEqualTo(String value) {
			addCriterion("rank =", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankNotEqualTo(String value) {
			addCriterion("rank <>", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankGreaterThan(String value) {
			addCriterion("rank >", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankGreaterThanOrEqualTo(String value) {
			addCriterion("rank >=", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankLessThan(String value) {
			addCriterion("rank <", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankLessThanOrEqualTo(String value) {
			addCriterion("rank <=", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankLike(String value) {
			addCriterion("rank like", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankNotLike(String value) {
			addCriterion("rank not like", value, "rank");
			return (Criteria) this;
		}

		public Criteria andRankIn(List<String> values) {
			addCriterion("rank in", values, "rank");
			return (Criteria) this;
		}

		public Criteria andRankNotIn(List<String> values) {
			addCriterion("rank not in", values, "rank");
			return (Criteria) this;
		}

		public Criteria andRankBetween(String value1, String value2) {
			addCriterion("rank between", value1, value2, "rank");
			return (Criteria) this;
		}

		public Criteria andRankNotBetween(String value1, String value2) {
			addCriterion("rank not between", value1, value2, "rank");
			return (Criteria) this;
		}

		public Criteria andStandardIsNull() {
			addCriterion("standard is null");
			return (Criteria) this;
		}

		public Criteria andStandardIsNotNull() {
			addCriterion("standard is not null");
			return (Criteria) this;
		}

		public Criteria andStandardEqualTo(String value) {
			addCriterion("standard =", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotEqualTo(String value) {
			addCriterion("standard <>", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardGreaterThan(String value) {
			addCriterion("standard >", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardGreaterThanOrEqualTo(String value) {
			addCriterion("standard >=", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLessThan(String value) {
			addCriterion("standard <", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardLessThanOrEqualTo(String value) {
			addCriterion("standard <=", value, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardIn(List<String> values) {
			addCriterion("standard in", values, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotIn(List<String> values) {
			addCriterion("standard not in", values, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardBetween(String value1, String value2) {
			addCriterion("standard between", value1, value2, "standard");
			return (Criteria) this;
		}

		public Criteria andStandardNotBetween(String value1, String value2) {
			addCriterion("standard not between", value1, value2, "standard");
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