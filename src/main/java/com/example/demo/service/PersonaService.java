package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public List<Persona> getPersonas() {
        List<Persona>personList=persoRepo.findAll();

        return personList;
    }

    @Override
    public void savePersona(Persona person) {
        persoRepo.save(person);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona p=persoRepo.findById(id).orElse(null);
        return p;
    }

    @Override
    public void editPersona(Long oldId, Long newId, String newName, String newSurname, int newAge) {
        Persona p=this.findPersona(oldId);
        p.setId(newId);
        p.setNombre(newName);
        p.setApellido(newSurname);
        p.setEdad(newAge);

        this.savePersona(p);
    }

    @Override
    public void editPersona(Persona per) {
        this.savePersona(per);
    }


}
