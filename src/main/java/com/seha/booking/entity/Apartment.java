package com.seha.booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "apartments")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    private String title;
    private String description;
    private String location;
    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE, BOOKED
    }
}