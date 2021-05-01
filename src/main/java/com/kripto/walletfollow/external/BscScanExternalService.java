package com.kripto.walletfollow.external;

import com.kripto.walletfollow.constants.BscScanServiceEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


public class BscScanExternalService {

    private String EXTERNAL_URL;

    private String API_KEY;

    public BscScanExternalService(String EXTERNAL_URL, String API_KEY) {
        this.EXTERNAL_URL = EXTERNAL_URL;
        this.API_KEY = API_KEY;
    }

    public String getBNBBalanceByAdress(String hashAdress) throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        String url = EXTERNAL_URL + BscScanServiceEnum.GET_BNB_BALANCE.getUrl()+ hashAdress + "&apikey=" + API_KEY;

        URI uri = new URI(url);

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        return result.getBody();
    }

}
