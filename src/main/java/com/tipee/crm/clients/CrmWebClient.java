package com.tipee.crm.clients;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;

@Component
public class CrmWebClient {

    public Mono<ClientResponse> get(String domain, String id){
        WebClient webClient = WebClient.create(domain);
        return webClient.get().retrieve().bodyToMono(ClientResponse.class);
    }
}
    
