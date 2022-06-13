package com.company.core.stocks;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Random;

@Data
public class FXRL extends AbstractFX{

    private final String name = "FXRL (акции России)";

    private BigDecimal price;

    private static final int min = 1800;

    private static final int max = 4200;

    @PostConstruct
    private void generatePrice(){
        Random random = new Random();
        price = new BigDecimal(random.nextInt(max - min) + min);
    }

}
