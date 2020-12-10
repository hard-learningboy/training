package com.mcx.mall.tiny.service.impl;

import com.mcx.mall.tiny.dao.UmsAdminRoleRelationDao;
import com.mcx.mall.tiny.mbg.model.UmsPermission;
import com.mcx.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UmsAdminService实现类
 * @author mcx
 * @date 2020/12/10 9:46
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService{
    @Autowired
    private UmsAdminRoleRelationDao umsAdminRoleRelationDao;

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return umsAdminRoleRelationDao.getPermissionList(adminId);
    }
}
