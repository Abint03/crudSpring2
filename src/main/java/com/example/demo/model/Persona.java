package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    @OneToOne
    @JoinColumn(name="masc_id",referencedColumnName = "id")
    private Mascota masc;

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, int edad, Mascota masc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.masc=masc;
    }
}
