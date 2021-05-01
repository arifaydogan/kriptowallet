package com.kripto.walletfollow.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Wallet {

    private BigDecimal totalAmount;
    private Integer totalCoins;
    private List<Coin> coins;

}
