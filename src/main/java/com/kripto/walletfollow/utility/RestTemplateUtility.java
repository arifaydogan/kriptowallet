package com.kripto.walletfollow.utility;

import com.kripto.walletfollow.constants.BscScanServiceEnum;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public interface RestTemplateUtility {


    RestTemplate restTemplateBuilder();

    <T> T exchange(String param, BscScanServiceEnum service, ParameterizedTypeReference<T> responseType);
}
