package com.kripto.walletfollow.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum BscScanServiceEnum {

    GET_BNB_BALANCE("balance&address=");

    private String url;
}
