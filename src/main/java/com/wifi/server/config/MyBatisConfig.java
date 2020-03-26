package com.wifi.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiaoBaoCai
 * @description: 用于配置需要动态生成的mapper接口的路径
 */
@Configuration
@MapperScan("com.wifi.server.module.dao")
public class MyBatisConfig {
}
