package com.example.demo.controller;

import com.example.demo.model.Mascota;
import com.example.demo.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {
    @Autowired
    IMascotaService mascService;

    @GetMapping("mascotas/traer")
    public List<Mascota> traerMascotas(){
        return mascService.getMascotas();
    }

    @PostMapping("mascotas/guardar")
    public String saveMascota(@RequestBody Mascota m){
        mascService.saveMascota(m);
        return "Mascota añadida con éxito!";
    }

    @DeleteMapping("mascotas/borrar/{id}")
    public String deleteMascota(@PathVariable Long id){
        mascService.deleteMascota(id);
        return "Mascota eliminada con éxito!";
    }

    @GetMapping("mascotas/traer/{id}")
    public Mascota findMascota(@PathVariable Long id){
        return mascService.findMascota(id);
    }

    @PutMapping("mascotas/editar/{idViejo}")
    public Mascota editarMascota(@PathVariable Long idViejo, @RequestParam(required = false,name="id")Long id,@RequestParam(required = false,name="nombre") String nombre,
                                 @RequestParam(required = false,name="especie")String especie,@RequestParam(required = false,name="raza")String raza, @RequestParam(required = false,name="color")String color){
        return mascService.editMascota(idViejo,id,nombre,especie,raza,color);
    }
}
