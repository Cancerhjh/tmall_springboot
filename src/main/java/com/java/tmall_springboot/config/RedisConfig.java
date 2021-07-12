package com.java.tmall_springboot.config;



import org.springframework.cache.annotation.CachingConfigurerSupport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;

import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.data.redis.serializer.*;


@Configuration
public class RedisConfig extends CachingConfigurerSupport  {

    @Bean
    public RedisTemplate<String, Object>
    redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
    //解决乱码和加载失败的主要解决方法_RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
    @Bean
    public RedisCacheManager redisCacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig().disableCachingNullValues()
                .serializeValuesWith(
                        RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
        redisCacheConfiguration.usePrefix();

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration).build();
    }
}


/*om.activateDefaultTyping(
                LaissezFaireSubTypeValidator.instance ,
                ObjectMapper.DefaultTyping.NON_FINAL,
                JsonTypeInfo.As.WRAPPER_ARRAY);*/