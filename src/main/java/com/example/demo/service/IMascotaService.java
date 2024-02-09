package com.example.demo.service;


import com.example.demo.model.Mascota;

import java.util.List;

public interface IMascotaService {
    public List<Mascota> getMascotas();
    public void saveMascota(Mascota m);
    public Mascota findMascota(Long id);
    public void deleteMascota(Long id);
    public Mascota editMascota(Long idViejo, Long idNuevo, String nombre, String especie,
                                String raza, String color);
}
