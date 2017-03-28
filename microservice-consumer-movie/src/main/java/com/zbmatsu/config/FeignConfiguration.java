package com.zbmatsu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * 这是一个spring bean
 * 这样注入bean即可
 * 就可以不用配置文件了
 */
@Configuration
public class FeignConfiguration {

	@Bean
	public Contract feignContract(){
		return new feign.Contract.Default();
	}
}
