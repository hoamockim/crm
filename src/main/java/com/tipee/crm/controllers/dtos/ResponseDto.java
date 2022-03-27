package com.tipee.crm.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import reactor.core.publisher.Mono;

public class ResponseDto<T> {
    @Data
    public static class Meta {
        public Meta(int code, String serviceCode, String message) {
            this.code = code;
            this.serviceCode = serviceCode;
            this.message = message;
        }

        private int status;

        @JsonProperty("request_id")
        private String requestId;

        @JsonProperty("service_code")
        private String serviceCode;

        @JsonProperty
        private String message;

        @JsonProperty
        private int code;

        @JsonProperty("errors")
        Object errors;
    }

    @Getter
    @JsonProperty("meta")
    Meta meta;

    @Getter
    @JsonProperty("data")
    private T data;

    private void setMeta(Meta meta){
        this.meta = meta;
    }

    private void setData(T data){
        this.data = data;
    }

    public static ResponseDto getInstance(Object responseData) {
        ResponseDto res = new ResponseDto<>();
        Meta meta = new Meta(200, "", "Ok");
        res.setMeta(meta);
        res.setData(responseData);
        return res;
    }

    public static ResponseDto heathCheckSuccess() {
        ResponseDto res = new ResponseDto<>();
        Meta meta = new Meta(200, "", "ok");
        res.setMeta(meta);
        return res;
    }

    public static <T> Mono<ResponseDto> getMonoInstance(Mono<T> resData) {
       return resData.map((data) -> {
            ResponseDto res = new ResponseDto<>();
            Meta meta = new Meta(200, "", "ok");
            res.setMeta(meta);
            res.setData(data);
            return res;
        });
    }
}
