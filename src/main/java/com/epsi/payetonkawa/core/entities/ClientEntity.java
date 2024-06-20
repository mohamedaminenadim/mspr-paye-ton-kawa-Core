package com.epsi.payetonkawa.core.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clients")
@RequiredArgsConstructor
@Getter
@Setter
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clientID;

    @Column(name = "first_name", nullable=false)
    private String firstName;

    @Column(name = "family_name", nullable=false)
    private String familyName;

    @Transient
    private final String fullName = String.format("%s %s", firstName, familyName);

    @Column(name = "username", nullable=false)
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private ClientAddress address;

    @Column(name = "creation_date", nullable=false)
    private LocalDateTime createdAt;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<OrderEntity> commandes;

}
