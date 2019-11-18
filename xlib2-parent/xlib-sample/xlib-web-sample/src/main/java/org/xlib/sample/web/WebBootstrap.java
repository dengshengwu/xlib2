package org.xlib.sample.web;


/**
 * @Author: dengshengwu
 * @DateTime: 2019/10/25 17:27
 * @description:
 **/
public class WebBootstrap {
    private static final long M_SIZE = 1024*1024;
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory()/M_SIZE);
        System.out.println(Runtime.getRuntime().totalMemory()/M_SIZE);
        System.out.println(Runtime.getRuntime().freeMemory()/M_SIZE);
        String str = "Start";
        for (int i=1;i<=19999;i++) {
            str += String.valueOf(i);
        }
        str.intern();
        System.out.println(Runtime.getRuntime().maxMemory()/M_SIZE);
        System.out.println(Runtime.getRuntime().totalMemory()/M_SIZE);
        System.out.println(Runtime.getRuntime().freeMemory()/M_SIZE);
    }
}
