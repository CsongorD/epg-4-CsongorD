package com.codecool.elproyectegrande.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotNull
    private String name;
    private String type;
    private String description;
    private double price;
    private String image;
    private Long seller_id;
    private Long buyer_id;
    public boolean isAvailable(){return buyer_id == null;}
}
