package com.kripto.walletfollow.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ComponentScan(
        basePackages = {"springfox.documentation.swagger.schema", "springfox.documentation.swagger.readers", "springfox.documentation.swagger.web"}
)
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kripto"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("Kripto Wallet", "", "");
        return new ApiInfoBuilder()
                .title("Kripto Wallet Ui Rest Services")
                .description("Kripto WalletRest Services")
                .version("1.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }
}
