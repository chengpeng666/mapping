package cn.cmbnt.mapping;

import cn.cmbnt.mapping.context.AviatorContext;
import cn.cmbnt.mapping.function.collection.In;
import cn.cmbnt.mapping.function.collection.Notin;
import cn.cmbnt.mapping.function.general.Age;
import cn.cmbnt.mapping.function.general.ChineseNumberUpper;
import cn.cmbnt.mapping.function.general.DiffDays;
import cn.cmbnt.mapping.function.general.StringNumbersSum;
import cn.cmbnt.mapping.function.number.*;
import cn.cmbnt.mapping.function.object.Nvl;
import cn.cmbnt.mapping.function.object.SplitByLength;
import cn.cmbnt.mapping.function.object.ToNumber;
import cn.cmbnt.mapping.function.object.ToString;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @description: Aviator引擎执行器
 * @Date : 2018/9/7 下午3:21
 * @Author : 石冬冬-Seig Heil(shiyongxin2010@163.com)
 */
@Slf4j
public final class AviatorExecutor {
    static {
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_FLOATING_POINT_NUMBER_INTO_DECIMAL, true);
        AviatorEvaluator.setOption(Options.MATH_CONTEXT, MathContext.DECIMAL128);
        AviatorEvaluator.addFunction(new Nvl());
        AviatorEvaluator.addFunction(new Sum());
        AviatorEvaluator.addFunction(new Min());
        AviatorEvaluator.addFunction(new Max());
        AviatorEvaluator.addFunction(new Round());
        AviatorEvaluator.addFunction(new Ceil());
        AviatorEvaluator.addFunction(new Floor());
        AviatorEvaluator.addFunction(new Scale());
        AviatorEvaluator.addFunction(new In());
        AviatorEvaluator.addFunction(new Notin());
        AviatorEvaluator.addFunction(new DiffDays());
        AviatorEvaluator.addFunction(new Age());
        AviatorEvaluator.addFunction(new ChineseNumberUpper());
        AviatorEvaluator.addFunction(new StringNumbersSum());
        AviatorEvaluator.addFunction(new ToNumber());
        AviatorEvaluator.addFunction(new ToString());
        AviatorEvaluator.addFunction(new SplitByLength());
    }

    private AviatorExecutor(){}
    /**
     * 执行结果
     * @param context 上下文对象
     * @return
     */
    public static Object execute(AviatorContext context){
        Object result = AviatorEvaluator.execute(context.getExpression(), context.getEnv(), context.isCached());
        log.info("Aviator执行器context={},result={}", context,result);
        return result;
    }

    /**
     * 执行结果，返回boolean类型
     * @param context 上下文对象
     * @return
     */
    public static boolean executeBoolean(AviatorContext context){
        return (Boolean) execute(context);
    }

    /**
     * 执行结果，返回double类型
     * @param context 上下文对象
     * @return
     */
    public static double executeDouble(AviatorContext context){
        return Double.valueOf(execute(context).toString());
    }

    /**
     * 执行结果，返回BigDecimal类型
     * @param context 上下文对象
     * @return
     */
    public static BigDecimal executeBigDecimal(AviatorContext context){
        return new BigDecimal(execute(context).toString());
    }

    /**
     * 执行结果，返回BigDecimal类型
     * @param context 上下文对象
     * @return
     */
    public static String executeString(AviatorContext context){
        return (String)execute(context);
    }
}
