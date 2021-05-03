package com.kripto.walletfollow;

import com.kripto.walletfollow.utility.RestTemplateUtility;
import com.kripto.walletfollow.utility.RestTemplateUtilityImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class WalletfollowApplication {

    public static void main(String[] args) {
        SpringApplication.run(WalletfollowApplication.class, args);
    }

}
