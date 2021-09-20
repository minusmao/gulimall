package com.example.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @ClassName: CorsConfiguration
 * @Description: 跨域配置
 * @Author: TechRice
 * @Date: 2021/9/20 17:41
 */
@Configuration
public class GulimallCorsConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter() {
        // 跨域配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedHeader("*");        // 允许任意头
        corsConfiguration.addAllowedMethod("*");        // 允许任意方法
        corsConfiguration.addAllowedOrigin("*");        // 允许任意来源
        corsConfiguration.setAllowCredentials(true);    // 允许携带 cookie

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 任意路径 /** 使用此配置
        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}
