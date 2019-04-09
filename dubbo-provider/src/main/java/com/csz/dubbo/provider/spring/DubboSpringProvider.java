package com.csz.dubbo.provider.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author caishengzhi
 * @date 2018/3/5 10:29
 */
public class DubboSpringProvider {

    public static void main(String[] args) throws IOException {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");

        String[] xmls = new String[]{
//            "dubbo-practise-provider.xml"
            "dubbo-provider-noRegistry.xml"
        };

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider.xml"});
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(xmls);
        context.start();

        System.in.read(); // press any key to exit
    }

}
