package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService personService;

    @GetMapping("/personas/traer")
    public List<Persona> traerPersonas(){
        List<Persona>personas=personService.getPersonas();
        return personas;
    }

    @GetMapping("/personas/traer/{id}")
    public Persona traerPersona(@PathVariable Long id){
        return personService.findPersona(id);
    }

    @PostMapping("/personas/guardar")
    public String guardarPersona(@RequestBody Persona p){
        personService.savePersona(p);
        return "La persona se ha añadido con éxito!";
    }

    @PutMapping("/personas/editar/{idOrig}")
    public Persona editarPersona(@PathVariable Long idOrig,
                              @RequestParam(required = false,name="id") Long idNuevo,
                              @RequestParam(required = false,name="nombre") String nombreN,
                              @RequestParam(required = false,name="apellido") String apellidoN,
                              @RequestParam(required = false,name="edad") int edadN){
        personService.editPersona(idOrig,idNuevo,nombreN,apellidoN,edadN);
        return personService.findPersona(idNuevo);
    }

    @DeleteMapping("/personas/delete/{id}")
    public String deletePersona(@PathVariable Long id){
        personService.deletePersona(id);
        return "La persona se ha eliminado con éxito!";
    }
}
