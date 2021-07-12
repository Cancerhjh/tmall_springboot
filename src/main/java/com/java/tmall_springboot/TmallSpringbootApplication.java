package com.java.tmall_springboot;

import com.java.tmall_springboot.util.PortUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class})
@EnableCaching
@EnableElasticsearchRepositories(basePackages = "com.java.tmall_springboot.es")
@EnableJpaRepositories(basePackages = {"com.java.tmall_springboot.dao", "com.java.tmall_springboot.pojo"})
public class TmallSpringbootApplication {

    static {
        PortUtil.checkPort(6379,"Redis 服务端",true);
    }
    public static void main(String[] args) {
        SpringApplication.run(TmallSpringbootApplication.class, args);
    }

}
