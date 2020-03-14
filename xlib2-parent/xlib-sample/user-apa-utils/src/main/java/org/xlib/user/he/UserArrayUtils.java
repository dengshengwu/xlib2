package org.xlib.user.he;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/12/14 11:08
 * @description:
 **/
public class UserArrayUtils {

    public static void empty() {
        String[] list = {};
        System.err.println( ArrayUtils.isNotEmpty(list));
    }

    public static void add(){
        String[] list = {};
        list = ArrayUtils.add(list,"Java");
        list = ArrayUtils.add(list,"C++");
        list = ArrayUtils.add(list,"C#");
        list = ArrayUtils.add(list,"C");
        System.err.println(JSON.toJSONString(list));
    }


    public static void isSorted(){
        String[] list = {};
        list = ArrayUtils.add(list,"3Java");
        list = ArrayUtils.add(list,"2C++");
        list = ArrayUtils.add(list,"1C#");
        list = ArrayUtils.add(list,"0C");
        System.err.println(JSON.toJSONString(list));
        System.err.println(JSON.toJSONString(ArrayUtils.isSorted(list)));
    }

    public static void fun003(){

    }



    public static void fun004(){


    }



    public static void fun005(){


    }


    public static void fun006(){


    }



    public static void fun007(){


    }


    public static void fun008(){


    }

    public static void fun009(){


    }

    public static void fun010(){


    }


}
