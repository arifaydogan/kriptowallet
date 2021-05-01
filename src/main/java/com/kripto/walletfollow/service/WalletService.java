package com.kripto.walletfollow.service;

import com.kripto.walletfollow.dto.response.Wallet;

import java.io.IOException;
import java.net.URISyntaxException;

public interface WalletService {

    Wallet findWallet(String walletHashCode) throws IOException, URISyntaxException;

}
