package com.kripto.walletfollow.controller;

import com.kripto.walletfollow.dto.request.WalletReq;
import com.kripto.walletfollow.dto.response.Wallet;
import com.kripto.walletfollow.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController {

    @Autowired
    WalletService serviceWallet;


    @RequestMapping(path = "/find", method = RequestMethod.POST)
    Wallet findWallet(@RequestBody WalletReq walletReq) throws IOException, URISyntaxException {
        return serviceWallet.findWallet(walletReq.getWalletHashCode());
    }

}
