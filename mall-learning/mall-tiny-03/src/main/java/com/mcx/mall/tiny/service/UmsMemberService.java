package com.mcx.mall.tiny.service;

import com.mcx.mall.tiny.common.api.CommonResult;

/**
 * @author mcx
 * @date 2020/12/7 16:31
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone
     * @return CommonResult
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断手机号和验证码是否匹配
     * @param telephone
     * @param authCode
     * @return CommonResult
     */
    CommonResult verifyAuthCode(String telephone,String authCode);
}
