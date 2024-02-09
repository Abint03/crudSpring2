package com.example.demo.service;

import com.example.demo.model.Mascota;
import com.example.demo.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository repoMasc;
    @Override
    public List<Mascota> getMascotas() {
        return repoMasc.findAll();
    }

    @Override
    public void saveMascota(Mascota m) {
        repoMasc.save(m);
    }

    @Override
    public Mascota findMascota(Long id) {
        return repoMasc.findById(id).orElse(null);
    }

    @Override
    public void deleteMascota(Long id) {
        repoMasc.deleteById(id);
    }

    @Override
    public Mascota editMascota(Long idViejo, Long idNuevo, String nombre, String especie, String raza, String color) {
        Mascota m=this.findMascota(idViejo);
        m.setId_mascota(idNuevo);
        m.setNombre(nombre);
        m.setEspecie(especie);
        m.setRaza(raza);
        m.setColor(color);

        this.saveMascota(m);
        return m;
    }
}
