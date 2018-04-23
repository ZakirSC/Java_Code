package com.burnaev.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlMap;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
}
