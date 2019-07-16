package com.csz.rpc.provider;

import com.csz.rpc.api.SelfRpcServiceApi;
import com.csz.rpc.framework.RpcFramework;
import com.csz.rpc.impl.SelfRpcServiceApiImpl;

/**
 * @author: codefans
 * @date: 2019-06-25 09:59
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        SelfRpcServiceApi service = new SelfRpcServiceApiImpl();
        RpcFramework.export(service, 1234);
    }

}
