package com.tipee.crm.clients;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ApiClient {

    public Mono<ClientResponse> get(String domain, String uri ,String id){
        WebClient webClient = WebClient.create(domain);
        return webClient.get()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(ClientResponse.class);
    }
}
    
