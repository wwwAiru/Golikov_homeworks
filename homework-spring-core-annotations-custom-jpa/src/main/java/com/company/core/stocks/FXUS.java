package com.company.core.stocks;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;

@Data
public class FXUS extends AbstractFX {

    private final String name = "FXUS (акции США)";

    private BigDecimal price;

    private static final int min = 3600;

    private static final int max = 5800;

    @PostConstruct
    private void generatePrice(){
        Random random = new Random();
        price = new BigDecimal(random.nextInt(max - min) + min);
    }

}
