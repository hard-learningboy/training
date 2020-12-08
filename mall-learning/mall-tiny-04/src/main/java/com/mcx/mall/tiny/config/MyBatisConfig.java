package com.mcx.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描接口
 *
 * @author mcx
 * @date 2020/12/1
 */
@Configuration
@MapperScan("com.mcx.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
