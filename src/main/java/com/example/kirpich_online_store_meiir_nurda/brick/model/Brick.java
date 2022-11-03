package com.example.kirpich_online_store_meiir_nurda.brick.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
@Document("bricks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Brick {
    @Id
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
