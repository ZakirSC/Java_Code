package com.burnaev.models;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "marka_id")
    private Marka marka;
    private String model;
    private String color;
    private Integer power;
    private Double price;
    private String urlImageCar;
}
