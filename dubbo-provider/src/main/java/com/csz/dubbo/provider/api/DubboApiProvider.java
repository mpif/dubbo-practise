package com.csz.dubbo.provider.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.csz.rpc.api.DubboServiceRpcApi;
import com.csz.rpc.impl.DubboServiceRpcImpl;

import java.io.IOException;

/**
 * @author: codefans
 * @date: 2019-07-31 16:00
 */
public class DubboApiProvider {

    public static void main(String[] args) {
        DubboApiProvider apiProvider = new DubboApiProvider();
        apiProvider.startup();
    }

    public void startup() {

        DubboServiceRpcApi dubboServiceRpcApi = new DubboServiceRpcImpl();

        /**
         * 应用配置
         */
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("APIProvider_Application");

        /**
         * 注册中心配置
         */
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        //zookeeper://10.58.87.142:2182?backup=10.58.87.142:2183,10.58.87.142:2184
        registryConfig.setAddress("10.58.87.142:2182,10.58.87.142:2183,10.58.87.142:2184");
        registryConfig.setGroup("std-test");
//        registryConfig.setUsername("");
//        registryConfig.setPassword("");

        /**
         * 协议配置
         */
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setSerialization("kryo");
        protocol.setPort(22880);
        protocol.setThreads(200);

        /**
         * 服务提供者暴露服务配置
         */
        ServiceConfig<DubboServiceRpcApi> service = new ServiceConfig<DubboServiceRpcApi>();
        service.setApplication(applicationConfig);
        service.setRegistry(registryConfig);
        service.setProtocol(protocol);
        service.setInterface(DubboServiceRpcApi.class);
        service.setRef(dubboServiceRpcApi);
        service.setVersion("1.0.0");

        /**
         * 暴露及注册服务
         */
        service.export();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
