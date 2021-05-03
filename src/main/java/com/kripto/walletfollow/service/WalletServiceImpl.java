package com.kripto.walletfollow.service;

import com.kripto.walletfollow.dto.response.Wallet;
import com.kripto.walletfollow.external.BscScanExternalService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class WalletServiceImpl implements WalletService {

    @Value("${bscscan.baseurl}")
    private String EXTERNAL_URL;

    @Value("${bscscan.apikey}")
    private String API_KEY;

    @Autowired
    BscScanExternalService service;

    @Override
    public Wallet findWallet(String walletHashCode) throws IOException, URISyntaxException {

//        String url = "https://bscscan.com/address/"+walletHashCode;
//
//        Document doc = Jsoup.connect(url).get();
//
//        doc.select("p").forEach(System.out::println);
//
//        return null;

        String s = service.getBNBBalanceByAdress("0x6Ab381b04d86226a20C77b961422FD6FDf6DED4b");
        return null;
    }
}
