package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String apellido;
    private int edad;
    @OneToMany(mappedBy = "owner")
    private List<Mascota> lista_masc;

    public Persona() {
    }

    public Persona(long id, String nombre, String apellido, int edad, List<Mascota> lista_masc) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.lista_masc=lista_masc;
    }
}
