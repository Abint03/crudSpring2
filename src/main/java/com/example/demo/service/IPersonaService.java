package com.example.demo.service;

import com.example.demo.model.Mascota;
import com.example.demo.model.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona person);
    public void deletePersona(Long id);
    public Persona findPersona(Long id);
    public void editPersona(Long oldId, Long newId, String newName, String newSurname, int newAge);

    void editPersona(Persona per);
}
