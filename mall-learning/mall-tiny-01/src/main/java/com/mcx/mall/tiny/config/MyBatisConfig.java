package com.mcx.mall.tiny.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mcx on 2020/12/1.
 */

@Configuration
@MapperScan("com.mcx.mall.tiny.mbg.mapper")
public class MyBatisConfig {
}
