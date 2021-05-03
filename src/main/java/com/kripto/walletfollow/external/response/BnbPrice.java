package com.kripto.walletfollow.external.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BnbPrice {
    //"ethbtc":"0.01097","ethbtc_timestamp":"1619962449","ethusd":"623.39","ethusd_timestamp":"1619962448"
    private BigDecimal ethbtc;
    private Date ethbtc_timestamp;
    private BigDecimal ethusd;
    private Date ethusd_timestamp;
}
