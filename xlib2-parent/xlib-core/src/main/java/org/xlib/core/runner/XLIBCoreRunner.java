package org.xlib.core.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/10/24 11:49
 * @description:
 **/
@Slf4j
public class XLIBCoreRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        log.info("xlib core starting ...");
    }
}
