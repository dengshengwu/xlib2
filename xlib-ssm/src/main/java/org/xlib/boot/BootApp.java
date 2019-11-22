package org.xlib.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/19 16:47
 * @description:
 **/
@SpringBootApplication
@ComponentScan({"org.xlib"})
public class BootApp {
    public static int sleepSeconds = 5;
    public static long initSize = 90000L;


    public static void main(String[] args) {
        SpringApplication.run(BootApp.class);
        try{
            sleepSeconds = Integer.valueOf(args[0]);
            initSize = Long.valueOf(args[1]);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
