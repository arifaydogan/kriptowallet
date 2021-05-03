package com.kripto.walletfollow.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kripto.walletfollow.constants.BscScanServiceEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateUtilityImpl implements RestTemplateUtility {

    @Value("${bscscan.baseurl}")
    private String EXTERNAL_URL;

    @Value("${bscscan.apikey}")
    private String API_KEY;


    private ObjectMapper objectMapper;

    @Override
    public RestTemplate restTemplateBuilder() {

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(60000);
        httpRequestFactory.setConnectTimeout(60000);
        httpRequestFactory.setReadTimeout(60000);

        RestTemplate restTemplate = new RestTemplate();
/**        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
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
        }); **/
        return restTemplate;
    }


    public <T> T exchange(String param,BscScanServiceEnum service, ParameterizedTypeReference<T> responseType) {

        String url = EXTERNAL_URL + service.getBaseUrl()+service.getServiceUrl()+ param + "&apikey=" + API_KEY;

        return restTemplateBuilder().exchange(url, HttpMethod.GET, null, responseType).getBody();
    }


}
