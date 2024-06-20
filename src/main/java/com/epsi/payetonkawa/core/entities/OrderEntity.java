package com.epsi.payetonkawa.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes")
@RequiredArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commandeID;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "clientID")
    private ClientEntity client;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderID")
    private List<ProductEntity> produits;

    @Column(name = "creation_date", nullable=false)
    private LocalDateTime createdAt;
}
