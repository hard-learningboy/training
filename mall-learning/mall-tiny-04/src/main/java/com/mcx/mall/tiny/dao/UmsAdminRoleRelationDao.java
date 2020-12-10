package com.mcx.mall.tiny.dao;

import com.mcx.mall.tiny.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色管理自定义Dao
 * @author mcx
 * @date 2020/12/10 8:37
 */
public interface UmsAdminRoleRelationDao {

    /**
     * 获取用户所有权限（包括用户表相关的 + - 权限）
     * @param adminId
     * @return List<UmsPermission>
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
