package com.example.kirpich_online_store_meiir_nurda.brick.repository;


import io.spring.guides.gs_producing_web_service.Brick;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BrickRepository {
    private static final Map<String, Brick> bricks = new HashMap<>();

    @PostConstruct
    public void initData() {
        Brick ceramica = new Brick();
        ceramica.setName("Кирпич керамический лицевой пустотелый");
        ceramica.setFormat(234);
        ceramica.setPrice(123);
        ceramica.setWeight(1.4);

        bricks.put(ceramica.getName(), ceramica);

        Brick taiga = new Brick();
        ceramica.setName("Тайга Морион Лава");
        ceramica.setFormat(134);
        ceramica.setPrice(200);
        ceramica.setWeight(1.3);

        bricks.put(taiga.getName(), taiga);

        Brick fleshDart = new Brick();
        ceramica.setName("Флеш Дарт");
        ceramica.setFormat(245);
        ceramica.setPrice(250);
        ceramica.setWeight(2);

        bricks.put(fleshDart.getName(), fleshDart);
    }

    public Brick findBrick(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return bricks.get(name);
    }
}
