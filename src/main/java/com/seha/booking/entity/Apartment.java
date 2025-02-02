package com.seha.booking.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private double pricePerNight;
    private String location;
    private int bedrooms;
    private int bathrooms;
    private int maxGuests;
    private LocalDate availableFrom;
    private LocalDate availableTo;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}