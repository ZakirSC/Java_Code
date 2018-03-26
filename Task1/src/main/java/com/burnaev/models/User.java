package com.burnaev.models;

import lombok.*;

import javax.persistence.*;
import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String homeTown;
    private String email;
    private String password;
    private String confirmCode;
    private LocalDateTime expiredDate;
    private LocalDateTime registrationTime;

    @OneToMany(mappedBy = "user")
    private List<Bucket> bucketList;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @Enumerated(value = EnumType.STRING)
    private Role role;
}
