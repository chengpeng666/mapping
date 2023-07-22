package cn.cmbnt.mapping.bean.dto;

import java.util.Map;

public class CalculateDto {
    /**
     * 表达式
     */
    private String expression;
    /**
     * 表达式参数
     */
    private Map<String, Object> env;

    public CalculateDto() {
    }

    public CalculateDto(String expression, Map<String, Object> env) {
        this.expression = expression;
        this.env = env;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Map<String, Object> getEnv() {
        return env;
    }

    public void setEnv(Map<String, Object> env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "CalculateDto{" +
                "expression='" + expression + '\'' +
                ", env=" + env +
                '}';
    }
}
