package com.mcx.mall.tiny.service.impl;

import com.mcx.mall.tiny.common.api.CommonResult;
import com.mcx.mall.tiny.service.RedisService;
import com.mcx.mall.tiny.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @author mcx
 * @date 2020/12/7 16:42
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authcode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authcode}")
    private String REDIS_KEY_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        String key = REDIS_KEY_PREFIX_AUTH_CODE + telephone;
        String value = stringBuffer.toString();
        Long expire = Long.parseLong(REDIS_KEY_EXPIRE_SECONDS);
        redisService.set(key , value);
        redisService.expire(key , expire);
        return CommonResult.success(stringBuffer.toString(),"获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(telephone)){
            return CommonResult.failed("请输入手机号");
        }
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码");
        }
        String key = REDIS_KEY_PREFIX_AUTH_CODE + telephone;
        String realAuthCode = redisService.get(key);
        boolean result = authCode.equals(realAuthCode);
        if(result){
            return CommonResult.success(null,"验证码校验成功");
        }else{
            return CommonResult.failed("验证码不正确");
        }
    }
}
