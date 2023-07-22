package cn.cmbnt.mapping.service;

        import java.util.Map;

public interface MappingCoreService {
    Object getResult(String expression, Map<String, Object> env);
}
