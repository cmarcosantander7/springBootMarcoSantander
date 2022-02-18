package com.example.cursospringboot.app.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    private String clave;

    @Column(name="mail", nullable = false, length = 50, unique = true)
    private String email;

    private Boolean enabled;


    private String foto;

    private String cedula;

    @Transient
    private String fotoUrl;

    @Transient
    private String cedulaUrl;


}
