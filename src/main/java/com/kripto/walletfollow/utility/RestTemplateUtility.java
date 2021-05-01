package com.kripto.walletfollow.utility;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface RestTemplateUtility {


    RestTemplate restTemplateBuilder();

    <O, I> ResponseEntity<O> exchangeAll(I request, Class<O> outputClass, String ippAdress, String serviceUrl);

    <O, I> ResponseEntity<O> exchangeAll(I request, ParameterizedTypeReference<O> outputClass, String ippAdress, String serviceUrl);

    <O, I> ResponseEntity<O> exchangeAll(I request, Class<O> outputClass, String ippAdress, String serviceUrl, MediaType mediaType, HttpMethod httpMethod, String token);

    <O, I> ResponseEntity<O> exchangeAll(I request, ParameterizedTypeReference<O> outputClass, String ippAdress, String serviceUrl, MediaType mediaType, HttpMethod httpMethod, String token);

    <T> T convertFromJson(ResponseEntity<Object> response, Class<T> clazz);

    <T> T convertFromLinked(ResponseEntity<Object> response, Class<T> clazz);

}
