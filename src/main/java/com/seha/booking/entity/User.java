package com.seha.booking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role; // CUSTOMER, OWNER, ADMIN

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Apartment> apartments;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
