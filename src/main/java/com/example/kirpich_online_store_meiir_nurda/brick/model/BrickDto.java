package com.example.kirpich_online_store_meiir_nurda.brick.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrickDto {
    private Long id;
    private double format;
    private String name;
    private String frostResistance;
    private String photo;
    private double price;
    private String color;
    private double weight;
    private String size;
    private int consumption;
    private int amount;
}
