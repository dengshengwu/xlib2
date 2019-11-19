/**

package org.xlib.ssm.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


 * @Author: dengshengwu
 * @DateTime: 2019/11/19 17:42
 * @description:

@Component
public class WebFluxHandle {
    public Mono<ServerResponse> de1(ServerRequest servletRequest) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
                body(BodyInserters.fromObject("Hello Is WebFlux!"));
    }
}


 **/

