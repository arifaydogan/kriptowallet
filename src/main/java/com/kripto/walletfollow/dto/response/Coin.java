package com.kripto.walletfollow.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Coin {
    private String name;
    private BigDecimal total;
    private BigDecimal usdCurrencyValue;

}
