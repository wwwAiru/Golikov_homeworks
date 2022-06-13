package com.company.core.stocks;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;

@Data
public class FXCN extends AbstractFX {

    private final String name = "FXCN (акции Китая)";

    private BigDecimal price;

    private static final int min = 1200;

    private static final int max = 6500;

    @PostConstruct
    private void generatePrice(){
        Random random = new Random();
        price = new BigDecimal(random.nextInt(max - min) + min);
    }

}
