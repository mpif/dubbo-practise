package com.csz.dubbo.consumer.spring;

import com.csz.rpc.api.DubboServiceRpcApi;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author caishengzhi
 * @date 2018/3/5 10:30
 */
public class DubboSpringConsumer {

    public static void main(String[] args) {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");

        String[] xmls = new String[]{
//            "dubbo-practise-consumer.xml"
                "dubbo-consumer-noRegistry.xml"
        };

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmls);
        context.start();
        DubboServiceRpcApi demoService = (DubboServiceRpcApi) context.getBean("dubboServiceRpcApi"); // get remote service proxy

        while (true) {
            try {
                Thread.sleep(1000);
                String hello = demoService.sayHello("world"); // call remote method
                System.out.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "]" + hello); // get result

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        }
    }

}
