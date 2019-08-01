package com.csz.rpc.api;

/**
 * @author: codefans
 * @date: 2019-08-01 16:44
 */
public class ProductServiceRpcApiStub implements ProductServiceRpcApi {

    private final ProductServiceRpcApi productServiceRpcApi;

    public ProductServiceRpcApiStub(ProductServiceRpcApi productServiceRpcApi) {
        this.productServiceRpcApi = productServiceRpcApi;
    }

    @Override
    public String queryProductName(String productNo) {

        String productName = "";
        try {

            System.out.println("stub before, productNo=" + productNo);

            productName = productServiceRpcApi.queryProductName(productNo);

            System.out.println("stub after, productNo=" + productNo + ", productName=" + productName);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return productName;
    }
}
