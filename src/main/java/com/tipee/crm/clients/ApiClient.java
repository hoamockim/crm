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

    public Mono<ClientResponse> post(String domain, String uri, ClientRequest body) {
        return WebClient.create(domain).post()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(ClientResponse.class);
    }

    public Mono<ClientResponse> patch(String domain, String uri, ClientRequest body) {
        return WebClient.create(domain).patch()
            .uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .retrieve()
            .bodyToMono(ClientResponse.class);
    }
}
    
