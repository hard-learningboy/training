package com.mcx.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * @author mcx
 * @date 2020/12/10
 */
public class UmsAdminLoginParam {

    @ApiModelProperty(value = "用户名" , required = true)
//    @NotEmpty(message = "用户名不为空")
    @NotEmpty(message = "用户名不为空")
    private String username;
    @ApiModelProperty(value = "密码" , required = true)
    @NotEmpty(message = "密码不为空")
    private String password;
}
