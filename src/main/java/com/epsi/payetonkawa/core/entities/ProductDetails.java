package com.epsi.payetonkawa.core.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name="price")
    private Double price;

    @Column(name="description")
    private String description;

    @Column(name="color")
    private String color;
}
