package com.mcx.mall.tiny.controller;

import com.mcx.mall.tiny.common.api.CommonResult;
import com.mcx.mall.tiny.mbg.model.UmsPermission;
import com.mcx.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 后台用户管理UmsAdminController
 * @author mcx
 * @date 2020/12/10 9:50
 */
@RestController
//@Controller
@Api(tags = "UmsAdminController" , description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;

    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);

    }
}
