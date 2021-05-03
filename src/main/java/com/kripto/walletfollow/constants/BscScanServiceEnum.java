package com.kripto.walletfollow.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BscScanServiceEnum {

    GET_BNB_BALANCE("account&action=","balance&address="),
    GET_BNB_PRICE("stats&action=","bnbprice");
    private String baseUrl;
    private String serviceUrl;
}
