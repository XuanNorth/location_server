package com.example.locationserver;

import jakarta.persistence.*;

import java.security.Timestamp;
import java.time.Instant;

@Entity
@Table
@lombok.Data
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.Builder
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private double latitude;
    private double longitude;
    private Instant timestamp;
}
