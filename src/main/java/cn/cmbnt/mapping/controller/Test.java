package cn.cmbnt.mapping.controller;

import cn.cmbnt.mapping.bean.dto.CalculateDto;
import cn.cmbnt.mapping.service.MappingCoreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class Test {
    @Resource
    private MappingCoreService mappingCoreService;

    @PostMapping("/fire")
    public Object getResult(@RequestBody CalculateDto calculateDto) {
        //目标集合
        Map<String, Object> resMap = new HashMap<>(16);
        Object result = mappingCoreService.getResult(calculateDto.getExpression(), calculateDto.getEnv());
        return result;
    }
}
