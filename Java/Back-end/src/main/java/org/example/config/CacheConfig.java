package org.example.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration () {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl( Duration.ofMinutes( 10 ) )
                .disableCachingNullValues();
    }
}
