package com.mcx.mall.tiny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 *
 * @author mcx
 * @date 2020/12/1
 */

//@EnableSwagger2
@SpringBootApplication
public class MallTinyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MallTinyApplication.class,args);
    }
}
