package org.xlib.ssm.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/11/19 17:14
 * @description:
 **/
@RestController
public class DeController {

    @GetMapping("/de1")
    public Object getD1(){
        Map<String,Object> result = new HashMap<>();
        result.put("status",true);
        result.put("data","Hi，Boot2.0.3");
        return result;
    }
}
