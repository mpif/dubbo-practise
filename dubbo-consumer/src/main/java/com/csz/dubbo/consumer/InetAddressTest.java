package com.csz.dubbo.consumer;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by caishengzhi on 2018/3/27.
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }

}
