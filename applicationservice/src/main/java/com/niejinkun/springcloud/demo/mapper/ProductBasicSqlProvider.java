package com.niejinkun.springcloud.demo.mapper;

import com.niejinkun.springcloud.demo.model.ProductBasic;
import com.niejinkun.springcloud.demo.model.ProductBasicExample.Criteria;
import com.niejinkun.springcloud.demo.model.ProductBasicExample.Criterion;
import com.niejinkun.springcloud.demo.model.ProductBasicExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductBasicSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String countByExample(ProductBasicExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product_basic");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String deleteByExample(ProductBasicExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product_basic");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String insertSelective(ProductBasic record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_basic");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getRateType() != null) {
            sql.VALUES("rate_type", "#{rateType,jdbcType=TINYINT}");
        }
        
        if (record.getRate() != null) {
            sql.VALUES("rate", "#{rate,jdbcType=DECIMAL}");
        }
        
        if (record.getRateMax() != null) {
            sql.VALUES("rate_max", "#{rateMax,jdbcType=DECIMAL}");
        }
        
        if (record.getRateMin() != null) {
            sql.VALUES("rate_min", "#{rateMin,jdbcType=DECIMAL}");
        }
        
        if (record.getFloatRate() != null) {
            sql.VALUES("float_rate", "#{floatRate,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentTerm() != null) {
            sql.VALUES("investment_term", "#{investmentTerm,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentMinMoney() != null) {
            sql.VALUES("investment_min_money", "#{investmentMinMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentMaxMoney() != null) {
            sql.VALUES("investment_max_money", "#{investmentMaxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            sql.VALUES("total_money", "#{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getLeftMoney() != null) {
            sql.VALUES("left_money", "#{leftMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getPeople() != null) {
            sql.VALUES("people", "#{people,jdbcType=INTEGER}");
        }
        
        if (record.getImg() != null) {
            sql.VALUES("img", "#{img,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getFootName() != null) {
            sql.VALUES("foot_name", "#{footName,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel() != null) {
            sql.VALUES("channel", "#{channel,jdbcType=SMALLINT}");
        }
        
        if (record.getOpenTime() != null) {
            sql.VALUES("open_time", "#{openTime,jdbcType=INTEGER}");
        }
        
        if (record.getVipOpenTime() != null) {
            sql.VALUES("vip_open_time", "#{vipOpenTime,jdbcType=INTEGER}");
        }
        
        if (record.getRateTime() != null) {
            sql.VALUES("rate_time", "#{rateTime,jdbcType=INTEGER}");
        }
        
        if (record.getOpenStatus() != null) {
            sql.VALUES("open_status", "#{openStatus,jdbcType=TINYINT}");
        }
        
        if (record.getUpdateAt() != null) {
            sql.VALUES("update_at", "#{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateAt() != null) {
            sql.VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String selectByExample(ProductBasicExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("code");
        sql.SELECT("type");
        sql.SELECT("status");
        sql.SELECT("rate_type");
        sql.SELECT("rate");
        sql.SELECT("rate_max");
        sql.SELECT("rate_min");
        sql.SELECT("float_rate");
        sql.SELECT("investment_term");
        sql.SELECT("investment_min_money");
        sql.SELECT("investment_max_money");
        sql.SELECT("total_money");
        sql.SELECT("left_money");
        sql.SELECT("people");
        sql.SELECT("img");
        sql.SELECT("title");
        sql.SELECT("foot_name");
        sql.SELECT("channel");
        sql.SELECT("open_time");
        sql.SELECT("vip_open_time");
        sql.SELECT("rate_time");
        sql.SELECT("open_status");
        sql.SELECT("update_at");
        sql.SELECT("create_at");
        sql.FROM("product_basic");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProductBasic record = (ProductBasic) parameter.get("record");
        ProductBasicExample example = (ProductBasicExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product_basic");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getRateType() != null) {
            sql.SET("rate_type = #{record.rateType,jdbcType=TINYINT}");
        }
        
        if (record.getRate() != null) {
            sql.SET("rate = #{record.rate,jdbcType=DECIMAL}");
        }
        
        if (record.getRateMax() != null) {
            sql.SET("rate_max = #{record.rateMax,jdbcType=DECIMAL}");
        }
        
        if (record.getRateMin() != null) {
            sql.SET("rate_min = #{record.rateMin,jdbcType=DECIMAL}");
        }
        
        if (record.getFloatRate() != null) {
            sql.SET("float_rate = #{record.floatRate,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentTerm() != null) {
            sql.SET("investment_term = #{record.investmentTerm,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentMinMoney() != null) {
            sql.SET("investment_min_money = #{record.investmentMinMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentMaxMoney() != null) {
            sql.SET("investment_max_money = #{record.investmentMaxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            sql.SET("total_money = #{record.totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getLeftMoney() != null) {
            sql.SET("left_money = #{record.leftMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getPeople() != null) {
            sql.SET("people = #{record.people,jdbcType=INTEGER}");
        }
        
        if (record.getImg() != null) {
            sql.SET("img = #{record.img,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getFootName() != null) {
            sql.SET("foot_name = #{record.footName,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel() != null) {
            sql.SET("channel = #{record.channel,jdbcType=SMALLINT}");
        }
        
        if (record.getOpenTime() != null) {
            sql.SET("open_time = #{record.openTime,jdbcType=INTEGER}");
        }
        
        if (record.getVipOpenTime() != null) {
            sql.SET("vip_open_time = #{record.vipOpenTime,jdbcType=INTEGER}");
        }
        
        if (record.getRateTime() != null) {
            sql.SET("rate_time = #{record.rateTime,jdbcType=INTEGER}");
        }
        
        if (record.getOpenStatus() != null) {
            sql.SET("open_status = #{record.openStatus,jdbcType=TINYINT}");
        }
        
        if (record.getUpdateAt() != null) {
            sql.SET("update_at = #{record.updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product_basic");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("rate_type = #{record.rateType,jdbcType=TINYINT}");
        sql.SET("rate = #{record.rate,jdbcType=DECIMAL}");
        sql.SET("rate_max = #{record.rateMax,jdbcType=DECIMAL}");
        sql.SET("rate_min = #{record.rateMin,jdbcType=DECIMAL}");
        sql.SET("float_rate = #{record.floatRate,jdbcType=DECIMAL}");
        sql.SET("investment_term = #{record.investmentTerm,jdbcType=DECIMAL}");
        sql.SET("investment_min_money = #{record.investmentMinMoney,jdbcType=DECIMAL}");
        sql.SET("investment_max_money = #{record.investmentMaxMoney,jdbcType=DECIMAL}");
        sql.SET("total_money = #{record.totalMoney,jdbcType=DECIMAL}");
        sql.SET("left_money = #{record.leftMoney,jdbcType=DECIMAL}");
        sql.SET("people = #{record.people,jdbcType=INTEGER}");
        sql.SET("img = #{record.img,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("foot_name = #{record.footName,jdbcType=VARCHAR}");
        sql.SET("channel = #{record.channel,jdbcType=SMALLINT}");
        sql.SET("open_time = #{record.openTime,jdbcType=INTEGER}");
        sql.SET("vip_open_time = #{record.vipOpenTime,jdbcType=INTEGER}");
        sql.SET("rate_time = #{record.rateTime,jdbcType=INTEGER}");
        sql.SET("open_status = #{record.openStatus,jdbcType=TINYINT}");
        sql.SET("update_at = #{record.updateAt,jdbcType=TIMESTAMP}");
        sql.SET("create_at = #{record.createAt,jdbcType=TIMESTAMP}");
        
        ProductBasicExample example = (ProductBasicExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(ProductBasic record) {
        SQL sql = new SQL();
        sql.UPDATE("product_basic");
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getRateType() != null) {
            sql.SET("rate_type = #{rateType,jdbcType=TINYINT}");
        }
        
        if (record.getRate() != null) {
            sql.SET("rate = #{rate,jdbcType=DECIMAL}");
        }
        
        if (record.getRateMax() != null) {
            sql.SET("rate_max = #{rateMax,jdbcType=DECIMAL}");
        }
        
        if (record.getRateMin() != null) {
            sql.SET("rate_min = #{rateMin,jdbcType=DECIMAL}");
        }
        
        if (record.getFloatRate() != null) {
            sql.SET("float_rate = #{floatRate,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentTerm() != null) {
            sql.SET("investment_term = #{investmentTerm,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentMinMoney() != null) {
            sql.SET("investment_min_money = #{investmentMinMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getInvestmentMaxMoney() != null) {
            sql.SET("investment_max_money = #{investmentMaxMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getTotalMoney() != null) {
            sql.SET("total_money = #{totalMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getLeftMoney() != null) {
            sql.SET("left_money = #{leftMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getPeople() != null) {
            sql.SET("people = #{people,jdbcType=INTEGER}");
        }
        
        if (record.getImg() != null) {
            sql.SET("img = #{img,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getFootName() != null) {
            sql.SET("foot_name = #{footName,jdbcType=VARCHAR}");
        }
        
        if (record.getChannel() != null) {
            sql.SET("channel = #{channel,jdbcType=SMALLINT}");
        }
        
        if (record.getOpenTime() != null) {
            sql.SET("open_time = #{openTime,jdbcType=INTEGER}");
        }
        
        if (record.getVipOpenTime() != null) {
            sql.SET("vip_open_time = #{vipOpenTime,jdbcType=INTEGER}");
        }
        
        if (record.getRateTime() != null) {
            sql.SET("rate_time = #{rateTime,jdbcType=INTEGER}");
        }
        
        if (record.getOpenStatus() != null) {
            sql.SET("open_status = #{openStatus,jdbcType=TINYINT}");
        }
        
        if (record.getUpdateAt() != null) {
            sql.SET("update_at = #{updateAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_basic
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, ProductBasicExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}