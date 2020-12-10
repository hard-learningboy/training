package com.mcx.mall.tiny.service;

import com.mcx.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台管理员Service
 * @author mcx
 * @date 2020/12/10 9:28
 */
public interface UmsAdminService {

    /**
     * 获取用户的所有权限（包括角色权限和与用户直接相关的+ - 权限）
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
