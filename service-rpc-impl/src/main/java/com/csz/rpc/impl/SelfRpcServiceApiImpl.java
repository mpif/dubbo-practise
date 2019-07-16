package com.csz.rpc.impl;

import com.csz.rpc.api.SelfRpcServiceApi;

/**
 * @author: codefans
 * @date: 2019-06-25 10:26
 */
public class SelfRpcServiceApiImpl implements SelfRpcServiceApi {
    @Override
    public String sayHi(String input) {
        System.out.println("request param[input=" + input + "]");
        return "response of input[" + input + "] is hi,[" + input + "]";
    }
}
