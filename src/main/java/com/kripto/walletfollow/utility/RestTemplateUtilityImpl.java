package com.kripto.walletfollow.utility;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Service
public class RestTemplateUtilityImpl implements RestTemplateUtility {

    private ObjectMapper objectMapper;

    @Override
    public RestTemplate restTemplateBuilder() {

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(60000);
        httpRequestFactory.setConnectTimeout(60000);
        httpRequestFactory.setReadTimeout(60000);

        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper);
        restTemplate.getMessageConverters().add(0, converter);
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        return restTemplate;
    }

    /**
     * ippAdress param : "http://localhost:9096/external"
     * serviceUrl param : send like "/test" .
     */
    @Override
    public <O, I> ResponseEntity<O> exchangeAll(I request, Class<O> outputClass, String ippAdress, String serviceUrl) {
        return exchangeAll(request, outputClass, ippAdress, serviceUrl, MediaType.APPLICATION_JSON, HttpMethod.POST, null);
    }


    @Override
    public <O, I> ResponseEntity<O> exchangeAll(I request, ParameterizedTypeReference<O> outputClass, String ippAdress, String serviceUrl) {
        return exchangeAll(request, outputClass, ippAdress, serviceUrl, MediaType.APPLICATION_JSON, HttpMethod.POST, null);
    }

    @Override
    public <O, I> ResponseEntity<O> exchangeAll(I request, Class<O> outputClass, String ippAdress, String serviceUrl, MediaType mediaType, HttpMethod httpMethod, String token) {
        String url = generateServiceUrl(ippAdress, serviceUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        Optional.ofNullable(token).ifPresent(s ->
                headers.set("Authorization", "Bearer " + token)
        );
        HttpEntity<I> entity = new HttpEntity<>(request, headers);

        return restTemplateBuilder().exchange(url, httpMethod, entity, outputClass);
    }


    @Override
    public <O, I> ResponseEntity<O> exchangeAll(I request, ParameterizedTypeReference<O> outputClass, String ippAdress, String serviceUrl, MediaType mediaType, HttpMethod httpMethod, String token) {
        String url = generateServiceUrl(ippAdress, serviceUrl);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(mediaType);
        Optional.ofNullable(token).ifPresent(s ->
                headers.set("Authorization", "Bearer " + token)
        );
        HttpEntity<I> entity = new HttpEntity<>(request, headers);

        return restTemplateBuilder().exchange(url, httpMethod, entity, outputClass);
    }

    @Override
    public <T> T convertFromJson(ResponseEntity<Object> response, Class<T> clazz) {
        return new Gson().fromJson(Objects.requireNonNull(response.getBody()).toString(), clazz);
    }


    public <T> T convertFromLinked(ResponseEntity<Object> response, Class<T> clazz) {
        return new ObjectMapper().convertValue(Objects.requireNonNull(response.getBody()), clazz);
    }


    private String generateServiceUrl(String ipAddr, String serviceUrl) {
        String url = null;
        String ipAddress = null;
        if (ipAddr != null) {
            ipAddress = ipAddr;
        }
        if (serviceUrl != null) {
            url = ipAddress + serviceUrl;
        }
        return url;
    }

}
