package com.seha.booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payments")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String transactionId;

    public enum Status {
        PAID, PENDING, FAILED
    }
}
