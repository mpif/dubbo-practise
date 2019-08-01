package com.csz.rpc.api;

/**
 * @author: codefans
 * @date: 2019-08-01 16:42
 */
public interface ProductServiceRpcApi {

    /**
     * 通过产品编号查询产品名称
     * @param productNo
     * @return
     */
    public String queryProductName(String productNo);

}
