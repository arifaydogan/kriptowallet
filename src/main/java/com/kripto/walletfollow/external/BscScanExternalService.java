package com.kripto.walletfollow.external;

import com.kripto.walletfollow.constants.BscScanServiceEnum;
import com.kripto.walletfollow.external.response.BaseBscScanResponse;
import com.kripto.walletfollow.external.response.BnbPrice;
import com.kripto.walletfollow.utility.RestTemplateUtility;
import com.kripto.walletfollow.utility.RestTemplateUtilityImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class BscScanExternalService {

    RestTemplateUtility restTemplate;

    @Autowired
    public BscScanExternalService(RestTemplateUtility restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getBNBBalanceByAdress(String hashAdress) throws URISyntaxException {


        BaseBscScanResponse<String> result = restTemplate.exchange(hashAdress,BscScanServiceEnum.GET_BNB_BALANCE, new ParameterizedTypeReference<BaseBscScanResponse<String>>() {});

        BaseBscScanResponse<BnbPrice> result1 = restTemplate.exchange("",BscScanServiceEnum.GET_BNB_PRICE, new ParameterizedTypeReference<BaseBscScanResponse<BnbPrice>>() {});

        return result.getResult();
    }


}
