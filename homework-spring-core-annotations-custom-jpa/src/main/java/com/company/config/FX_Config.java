package com.company.config;

import com.company.core.stocks.FXCN;
import com.company.core.stocks.FXRL;
import com.company.core.stocks.FXUS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FX_Config {

    private static final String PROTO_SCOPE = "prototype";


    @Bean
    @Scope(PROTO_SCOPE)
    public FXUS stockUS() {
        return new FXUS();
    }

    @Bean
    @Scope(PROTO_SCOPE)
    public FXRL stockRL() {
        return new FXRL();
    }

    @Bean
    @Scope(PROTO_SCOPE)
    public FXCN stockCN() {
        return new FXCN();
    }

}
