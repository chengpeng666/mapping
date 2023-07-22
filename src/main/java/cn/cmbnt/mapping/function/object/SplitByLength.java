package cn.cmbnt.mapping.function.object;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaType;
import com.googlecode.aviator.runtime.type.AviatorString;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitByLength extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {

        String orgStr = FunctionUtils.getStringValue(arg1, env);
        Integer length = Integer.valueOf(FunctionUtils.getNumberValue(arg2, env).toString());
        //如果源字符串为空，分割长度为0或者分割长度大于源字符串长度，则直接返回
        if (ObjectUtils.isEmpty(orgStr) || length == 0 || length >= orgStr.length()) {
            return new AviatorString(orgStr);
        }
        List<String> resList = new ArrayList<>();


        for (int i = 0; i < orgStr.length(); i = i + length) {
            String subStr;
            if (i + length <= orgStr.length()) {
                subStr = orgStr.substring(i, i + length);
            } else {
                subStr = orgStr.substring(i);
            }
            resList.add(subStr);
        }
        if (resList.size() == 1) {
            return new AviatorString(resList.get(0));
        } else {
            return AviatorRuntimeJavaType.valueOf(resList);
        }
    }

    @Override
    public String getName() {
        return "splitByLength";
    }

}
