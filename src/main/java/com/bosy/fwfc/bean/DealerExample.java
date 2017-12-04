package com.bosy.fwfc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DealerExample implements Serializable {
    private String orderByClause;

    private boolean distinct;

    private List<Criteria> oredCriteria;

    public DealerExample() {
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

        public Criteria andDealerIdIsNull() {
            addCriterion("dealer_id is null");
            return (Criteria) this;
        }

        public Criteria andDealerIdIsNotNull() {
            addCriterion("dealer_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealerIdEqualTo(Integer value) {
            addCriterion("dealer_id =", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotEqualTo(Integer value) {
            addCriterion("dealer_id <>", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThan(Integer value) {
            addCriterion("dealer_id >", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dealer_id >=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThan(Integer value) {
            addCriterion("dealer_id <", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdLessThanOrEqualTo(Integer value) {
            addCriterion("dealer_id <=", value, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdIn(List<Integer> values) {
            addCriterion("dealer_id in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotIn(List<Integer> values) {
            addCriterion("dealer_id not in", values, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdBetween(Integer value1, Integer value2) {
            addCriterion("dealer_id between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dealer_id not between", value1, value2, "dealerId");
            return (Criteria) this;
        }

        public Criteria andDealerCodeIsNull() {
            addCriterion("dealer_code is null");
            return (Criteria) this;
        }

        public Criteria andDealerCodeIsNotNull() {
            addCriterion("dealer_code is not null");
            return (Criteria) this;
        }

        public Criteria andDealerCodeEqualTo(String value) {
            addCriterion("dealer_code =", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotEqualTo(String value) {
            addCriterion("dealer_code <>", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeGreaterThan(String value) {
            addCriterion("dealer_code >", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_code >=", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeLessThan(String value) {
            addCriterion("dealer_code <", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeLessThanOrEqualTo(String value) {
            addCriterion("dealer_code <=", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeLike(String value) {
            addCriterion("dealer_code like", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotLike(String value) {
            addCriterion("dealer_code not like", value, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeIn(List<String> values) {
            addCriterion("dealer_code in", values, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotIn(List<String> values) {
            addCriterion("dealer_code not in", values, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeBetween(String value1, String value2) {
            addCriterion("dealer_code between", value1, value2, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerCodeNotBetween(String value1, String value2) {
            addCriterion("dealer_code not between", value1, value2, "dealerCode");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNull() {
            addCriterion("dealer_name is null");
            return (Criteria) this;
        }

        public Criteria andDealerNameIsNotNull() {
            addCriterion("dealer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDealerNameEqualTo(String value) {
            addCriterion("dealer_name =", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotEqualTo(String value) {
            addCriterion("dealer_name <>", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThan(String value) {
            addCriterion("dealer_name >", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_name >=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThan(String value) {
            addCriterion("dealer_name <", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLessThanOrEqualTo(String value) {
            addCriterion("dealer_name <=", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameLike(String value) {
            addCriterion("dealer_name like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotLike(String value) {
            addCriterion("dealer_name not like", value, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameIn(List<String> values) {
            addCriterion("dealer_name in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotIn(List<String> values) {
            addCriterion("dealer_name not in", values, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameBetween(String value1, String value2) {
            addCriterion("dealer_name between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerNameNotBetween(String value1, String value2) {
            addCriterion("dealer_name not between", value1, value2, "dealerName");
            return (Criteria) this;
        }

        public Criteria andDealerGradeIsNull() {
            addCriterion("dealer_grade is null");
            return (Criteria) this;
        }

        public Criteria andDealerGradeIsNotNull() {
            addCriterion("dealer_grade is not null");
            return (Criteria) this;
        }

        public Criteria andDealerGradeEqualTo(String value) {
            addCriterion("dealer_grade =", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeNotEqualTo(String value) {
            addCriterion("dealer_grade <>", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeGreaterThan(String value) {
            addCriterion("dealer_grade >", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_grade >=", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeLessThan(String value) {
            addCriterion("dealer_grade <", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeLessThanOrEqualTo(String value) {
            addCriterion("dealer_grade <=", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeLike(String value) {
            addCriterion("dealer_grade like", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeNotLike(String value) {
            addCriterion("dealer_grade not like", value, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeIn(List<String> values) {
            addCriterion("dealer_grade in", values, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeNotIn(List<String> values) {
            addCriterion("dealer_grade not in", values, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeBetween(String value1, String value2) {
            addCriterion("dealer_grade between", value1, value2, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerGradeNotBetween(String value1, String value2) {
            addCriterion("dealer_grade not between", value1, value2, "dealerGrade");
            return (Criteria) this;
        }

        public Criteria andDealerContactIsNull() {
            addCriterion("dealer_contact is null");
            return (Criteria) this;
        }

        public Criteria andDealerContactIsNotNull() {
            addCriterion("dealer_contact is not null");
            return (Criteria) this;
        }

        public Criteria andDealerContactEqualTo(String value) {
            addCriterion("dealer_contact =", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactNotEqualTo(String value) {
            addCriterion("dealer_contact <>", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactGreaterThan(String value) {
            addCriterion("dealer_contact >", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_contact >=", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactLessThan(String value) {
            addCriterion("dealer_contact <", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactLessThanOrEqualTo(String value) {
            addCriterion("dealer_contact <=", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactLike(String value) {
            addCriterion("dealer_contact like", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactNotLike(String value) {
            addCriterion("dealer_contact not like", value, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactIn(List<String> values) {
            addCriterion("dealer_contact in", values, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactNotIn(List<String> values) {
            addCriterion("dealer_contact not in", values, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactBetween(String value1, String value2) {
            addCriterion("dealer_contact between", value1, value2, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerContactNotBetween(String value1, String value2) {
            addCriterion("dealer_contact not between", value1, value2, "dealerContact");
            return (Criteria) this;
        }

        public Criteria andDealerNumIsNull() {
            addCriterion("dealer_num is null");
            return (Criteria) this;
        }

        public Criteria andDealerNumIsNotNull() {
            addCriterion("dealer_num is not null");
            return (Criteria) this;
        }

        public Criteria andDealerNumEqualTo(String value) {
            addCriterion("dealer_num =", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumNotEqualTo(String value) {
            addCriterion("dealer_num <>", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumGreaterThan(String value) {
            addCriterion("dealer_num >", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_num >=", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumLessThan(String value) {
            addCriterion("dealer_num <", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumLessThanOrEqualTo(String value) {
            addCriterion("dealer_num <=", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumLike(String value) {
            addCriterion("dealer_num like", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumNotLike(String value) {
            addCriterion("dealer_num not like", value, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumIn(List<String> values) {
            addCriterion("dealer_num in", values, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumNotIn(List<String> values) {
            addCriterion("dealer_num not in", values, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumBetween(String value1, String value2) {
            addCriterion("dealer_num between", value1, value2, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerNumNotBetween(String value1, String value2) {
            addCriterion("dealer_num not between", value1, value2, "dealerNum");
            return (Criteria) this;
        }

        public Criteria andDealerShengIsNull() {
            addCriterion("dealer_sheng is null");
            return (Criteria) this;
        }

        public Criteria andDealerShengIsNotNull() {
            addCriterion("dealer_sheng is not null");
            return (Criteria) this;
        }

        public Criteria andDealerShengEqualTo(String value) {
            addCriterion("dealer_sheng =", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengNotEqualTo(String value) {
            addCriterion("dealer_sheng <>", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengGreaterThan(String value) {
            addCriterion("dealer_sheng >", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_sheng >=", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengLessThan(String value) {
            addCriterion("dealer_sheng <", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengLessThanOrEqualTo(String value) {
            addCriterion("dealer_sheng <=", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengLike(String value) {
            addCriterion("dealer_sheng like", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengNotLike(String value) {
            addCriterion("dealer_sheng not like", value, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengIn(List<String> values) {
            addCriterion("dealer_sheng in", values, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengNotIn(List<String> values) {
            addCriterion("dealer_sheng not in", values, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengBetween(String value1, String value2) {
            addCriterion("dealer_sheng between", value1, value2, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShengNotBetween(String value1, String value2) {
            addCriterion("dealer_sheng not between", value1, value2, "dealerSheng");
            return (Criteria) this;
        }

        public Criteria andDealerShiIsNull() {
            addCriterion("dealer_shi is null");
            return (Criteria) this;
        }

        public Criteria andDealerShiIsNotNull() {
            addCriterion("dealer_shi is not null");
            return (Criteria) this;
        }

        public Criteria andDealerShiEqualTo(String value) {
            addCriterion("dealer_shi =", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiNotEqualTo(String value) {
            addCriterion("dealer_shi <>", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiGreaterThan(String value) {
            addCriterion("dealer_shi >", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_shi >=", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiLessThan(String value) {
            addCriterion("dealer_shi <", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiLessThanOrEqualTo(String value) {
            addCriterion("dealer_shi <=", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiLike(String value) {
            addCriterion("dealer_shi like", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiNotLike(String value) {
            addCriterion("dealer_shi not like", value, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiIn(List<String> values) {
            addCriterion("dealer_shi in", values, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiNotIn(List<String> values) {
            addCriterion("dealer_shi not in", values, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiBetween(String value1, String value2) {
            addCriterion("dealer_shi between", value1, value2, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerShiNotBetween(String value1, String value2) {
            addCriterion("dealer_shi not between", value1, value2, "dealerShi");
            return (Criteria) this;
        }

        public Criteria andDealerXianIsNull() {
            addCriterion("dealer_xian is null");
            return (Criteria) this;
        }

        public Criteria andDealerXianIsNotNull() {
            addCriterion("dealer_xian is not null");
            return (Criteria) this;
        }

        public Criteria andDealerXianEqualTo(String value) {
            addCriterion("dealer_xian =", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianNotEqualTo(String value) {
            addCriterion("dealer_xian <>", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianGreaterThan(String value) {
            addCriterion("dealer_xian >", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianGreaterThanOrEqualTo(String value) {
            addCriterion("dealer_xian >=", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianLessThan(String value) {
            addCriterion("dealer_xian <", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianLessThanOrEqualTo(String value) {
            addCriterion("dealer_xian <=", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianLike(String value) {
            addCriterion("dealer_xian like", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianNotLike(String value) {
            addCriterion("dealer_xian not like", value, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianIn(List<String> values) {
            addCriterion("dealer_xian in", values, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianNotIn(List<String> values) {
            addCriterion("dealer_xian not in", values, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianBetween(String value1, String value2) {
            addCriterion("dealer_xian between", value1, value2, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andDealerXianNotBetween(String value1, String value2) {
            addCriterion("dealer_xian not between", value1, value2, "dealerXian");
            return (Criteria) this;
        }

        public Criteria andFirmCodeIsNull() {
            addCriterion("firm_code is null");
            return (Criteria) this;
        }

        public Criteria andFirmCodeIsNotNull() {
            addCriterion("firm_code is not null");
            return (Criteria) this;
        }

        public Criteria andFirmCodeEqualTo(String value) {
            addCriterion("firm_code =", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeNotEqualTo(String value) {
            addCriterion("firm_code <>", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeGreaterThan(String value) {
            addCriterion("firm_code >", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeGreaterThanOrEqualTo(String value) {
            addCriterion("firm_code >=", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeLessThan(String value) {
            addCriterion("firm_code <", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeLessThanOrEqualTo(String value) {
            addCriterion("firm_code <=", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeLike(String value) {
            addCriterion("firm_code like", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeNotLike(String value) {
            addCriterion("firm_code not like", value, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeIn(List<String> values) {
            addCriterion("firm_code in", values, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeNotIn(List<String> values) {
            addCriterion("firm_code not in", values, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeBetween(String value1, String value2) {
            addCriterion("firm_code between", value1, value2, "firmCode");
            return (Criteria) this;
        }

        public Criteria andFirmCodeNotBetween(String value1, String value2) {
            addCriterion("firm_code not between", value1, value2, "firmCode");
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