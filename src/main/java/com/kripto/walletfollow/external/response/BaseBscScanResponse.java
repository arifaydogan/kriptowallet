package com.kripto.walletfollow.external.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseBscScanResponse<T> {

    private int status;
    private String message;
    private T result;
}
