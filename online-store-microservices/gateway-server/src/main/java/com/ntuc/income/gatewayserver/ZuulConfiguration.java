package com.ntuc.income.gatewayserver;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {

  @Bean
  RateLimiter rateLimiter() {
    return RateLimiter.create(100.0D / 10.0D);
  }

  @Bean
  RateLimitingFilter rateLimitingFilter(){
    return new RateLimitingFilter();
  }
}
