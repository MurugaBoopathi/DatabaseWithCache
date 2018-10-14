package com.example.dbcache.configuration;

import javax.annotation.PreDestroy;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@EnableCaching
@Configuration
@Slf4j
public class EhCacheConfiguration {

	/*@Bean
	public CacheManager cacheManager()
	{
		return new EhCacheCacheManager(cacheManagerFactory().getObject());
	}
	
	@Bean
	public EhCacheManagerFactoryBean cacheManagerFactory()
	{
		EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
		bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		bean.setShared(true);
		return bean;
	}*/
	
	EhCacheCacheManager ehCacheCacheManager;

    @Bean
    public CacheManager ordermanagementAppointmentCacheManager() {
        ClassPathResource ehCacheConfigFile = new ClassPathResource("ehcache.xml");
        this.ehCacheCacheManager = new EhCacheCacheManager(EhCacheManagerUtils.buildCacheManager(ehCacheConfigFile));
        return ehCacheCacheManager;
    }

    @PreDestroy
    public void destroy() {
    	log.info("Shutting down applicationCache.");
        this.ehCacheCacheManager.getCacheManager().shutdown();
    }
}
