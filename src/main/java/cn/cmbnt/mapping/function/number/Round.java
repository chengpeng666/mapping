package cn.cmbnt.mapping.function.number;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * @description: 四舍五入
 * @Date : 2018/9/7 下午5:40
 * @Author : 石冬冬-Seig Heil(shiyongxin2010@163.com)
 */
public class Round extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg) {
        Object value = arg.getValue(env);
        return AviatorDecimal.valueOf(Math.round(new Double(value.toString())));
    }

    @Override
    public String getName() {
        return "round";
    }
}
