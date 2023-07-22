package cn.cmbnt.mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MappingApplication {
    public static void main(String[] args) {
        SpringApplication.run(MappingApplication.class, args);
    }
}
