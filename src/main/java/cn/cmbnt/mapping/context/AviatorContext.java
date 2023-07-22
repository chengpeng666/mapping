package cn.cmbnt.mapping.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @description: Aviator 上下文
 * @Date : 2018/9/7 下午3:17
 * @Author : 石冬冬-Seig Heil(shiyongxin2010@163.com)
 */
@Data
@Builder
public class AviatorContext implements Serializable {
    /**
     * 表达式
     */
    private String expression;
    /**
     * 表达式参数
     */
    private Map<String, Object> env;
    /**
     * 是否缓存
     */
    private boolean cached;

    public AviatorContext() {
    }

    public AviatorContext(String expression, Map<String, Object> env, boolean cached) {
        this.expression = expression;
        this.env = env;
        this.cached = cached;
    }

    @Override
    public String toString() {
        return "AviatorContext{" +
                "expression='" + expression + '\'' +
                ", env=" + env +
                ", cached=" + cached +
                '}';
    }
}
