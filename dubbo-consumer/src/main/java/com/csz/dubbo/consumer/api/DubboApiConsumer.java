package com.csz.dubbo.consumer.api;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.csz.rpc.api.DubboServiceRpcApi;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: codefans
 * @date: 2019-07-31 16:00
 */
public class DubboApiConsumer {
    public static void main(String[] args) {
        DubboApiConsumer apiProvider = new DubboApiConsumer();
        apiProvider.startup();
    }

    public void startup() {

        /**
         * 应用配置
         */
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("APIConsumer_Application");

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
         * 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
         */

        /**
         * 引用远程服务
         * 此实例很重要，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄露
         */
        ReferenceConfig<DubboServiceRpcApi> reference = new ReferenceConfig<DubboServiceRpcApi>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(DubboServiceRpcApi.class);
        reference.setVersion("1.0.0");

        DubboServiceRpcApi dubboServiceRpcApi = reference.get();

        while (true) {
            try {
                Thread.sleep(1000);
                String hello = dubboServiceRpcApi.sayHello("world"); // call remote method
                System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "]" + hello); // get result

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        }

    }
}
