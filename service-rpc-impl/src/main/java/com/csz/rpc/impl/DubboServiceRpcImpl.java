package com.csz.rpc.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import com.csz.rpc.api.DubboServiceRpcApi;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author caishengzhi
 * @date 2018/3/5 14:36
 */

public class DubboServiceRpcImpl implements DubboServiceRpcApi {

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }


}
