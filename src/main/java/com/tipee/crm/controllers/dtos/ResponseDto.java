package com.tipee.crm.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import reactor.core.publisher.Mono;

public class ResponseDto<T> {
    @Data
    public static class Meta {
        public Meta( String serviceCode, String message) {
            this.serviceCode = serviceCode;
            this.message = message;
        }

        @JsonProperty("request_id")
        @JsonInclude(Include.NON_NULL)
        private String requestId;

        @JsonProperty("service_code")
        @JsonInclude(Include.NON_NULL)
        private String serviceCode;

        @JsonProperty
        @JsonInclude(Include.NON_NULL)
        private String message;

        @JsonProperty("errors")
        @JsonInclude(Include.NON_NULL)
        Object errors;
    }

    @Getter
    @JsonProperty("meta")
    Meta meta;

    @Getter
    @JsonProperty("data")
    @JsonInclude(Include.NON_NULL)
    private T data;

    private void setMeta(Meta meta){
        this.meta = meta;
    }

    private void setData(T data){
        this.data = data;
    }

    public static ResponseDto getInstance(Object responseData) {
        ResponseDto res = new ResponseDto<>();
        Meta meta = new Meta(null, "Ok");
        res.setMeta(meta);
        res.setData(responseData);
        return res;
    }

    public static ResponseDto heathCheckSuccess() {
        ResponseDto res = new ResponseDto<>();
        Meta meta = new Meta(null, "Ok");
        res.setMeta(meta);
        return res;
    }

    public static <T> Mono<ResponseDto> getMonoInstance(Mono<T> resData) {
       return resData.map((data) -> {
            ResponseDto res = new ResponseDto<>();
            Meta meta = new Meta(null, "Ok");
            res.setMeta(meta);
            res.setData(data);
            return res;
        });
    }

    public static <T> Mono<ResponseDto> getMonnoInstanceFromData(T data, String serviceCode, String message) {
        ResponseDto res = new ResponseDto<>();
        Meta meta = new Meta( serviceCode, message);
        res.setMeta(meta);
        res.setData(data);
        return Mono.just(res);
    }
}
