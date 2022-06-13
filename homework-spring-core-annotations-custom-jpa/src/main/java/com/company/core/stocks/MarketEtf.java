package com.company.core.stocks;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class MarketEtf {

    @Lookup
    public FXUS getFXUS() {
        return null;
    }

    @Lookup
    public FXRL getFXRL() {
        return null;
    }

    @Lookup
    public FXCN getFXCN() {
        return null;
    }


}
