package com.mcx.mall.tiny.common.api;

/**
 * 封装API的错误码
 *
 * @author mcx
 * @date 2020/12/1
 */
public interface IErrorCode {
    /**
     * get code
     *
     * @return long
     */
    long getCode();

    /**
     * get message
     *
     * @return String
     */
    String getMessage();
}
