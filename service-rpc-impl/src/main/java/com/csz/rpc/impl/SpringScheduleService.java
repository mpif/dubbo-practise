package com.csz.rpc.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by codefans on 2018/3/15.
 */
@Service
public class SpringScheduleService {

    public void schedule() {
        System.out.println("schedule ... " + new Date());


        throw new RuntimeException("exception in SpringScheduleService");

    }

}
