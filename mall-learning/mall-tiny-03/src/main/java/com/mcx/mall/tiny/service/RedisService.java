package com.mcx.mall.tiny.service;

/**
 * @author mcx
 * @date 2020/12/7 15:51
 */
public interface RedisService {

    /**
     * 获取数据
     * @param key
     * @return String
     */
    String get(String key);

    /**
     * 存储数据
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * 设置超时时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key,long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

}
