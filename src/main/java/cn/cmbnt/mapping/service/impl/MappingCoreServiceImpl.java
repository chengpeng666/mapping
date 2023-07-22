package cn.cmbnt.mapping.service.impl;

import cn.cmbnt.mapping.context.AviatorContext;
import cn.cmbnt.mapping.AviatorExecutor;
import cn.cmbnt.mapping.service.MappingCoreService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MappingCoreServiceImpl implements MappingCoreService {

    public Object getResult(String expression, Map<String, Object> env) {
        return AviatorExecutor.execute(new AviatorContext(expression, env, true));
    }
}
