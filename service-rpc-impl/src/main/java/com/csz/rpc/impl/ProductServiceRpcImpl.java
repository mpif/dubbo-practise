package com.csz.rpc.impl;

import com.csz.rpc.api.ProductServiceRpcApi;

/**
 * @author: codefans
 * @date: 2019-08-01 16:43
 */
public class ProductServiceRpcImpl implements ProductServiceRpcApi {
    @Override
    public String queryProductName(String productNo) {
        System.out.println("productNo=[" + productNo + "] from client!");
        return "this is the name of [" + productNo + "]";
    }
}
