package com.csz.rpc.consumer;

import com.csz.rpc.api.DubboServiceRpcApi;
import com.csz.rpc.api.SelfRpcServiceApi;
import com.csz.rpc.framework.RpcFramework;

/**
 * @author: codefans
 * @date: 2019-06-25 09:59
 */
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        SelfRpcServiceApi service = RpcFramework.refer(SelfRpcServiceApi.class, "127.0.0.1", 1234);
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            String hello = service.sayHi("World_" + i);
            System.out.println(hello);
            Thread.sleep(5000);
        }
    }

}
