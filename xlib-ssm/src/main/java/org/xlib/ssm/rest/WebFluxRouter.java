/**
package org.xlib.ssm.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


 * @Author: dengshengwu
 * @DateTime: 2019/11/19 19:41
 * @description:

@Configuration
public class WebFluxRouter {
    @Bean
    public RouterFunction<ServerResponse> routerDe(WebFluxHandle webFluxHandle){
        return RouterFunctions
                .route(RequestPredicates.GET("/flux/de01")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
        ,webFluxHandle::de1);
    }
}
 **/

