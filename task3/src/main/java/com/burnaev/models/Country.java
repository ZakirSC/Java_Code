package com.burnaev.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COUNTRY")
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}
