package com.springproj.demo.controller;

import com.springproj.demo.model.Medico;
import com.springproj.demo.model.Farmacia;
import com.springproj.demo.model.Receita;
import com.springproj.demo.service.MedicoService;
import com.springproj.demo.service.FarmaciaService;
import com.springproj.demo.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping
    public List<Receita> findAll() {
        return receitaService.findAll();
    }

    @GetMapping("/{id}")
    public Receita findById(@PathVariable Long id) {
        return receitaService.findById(id);
    }

    @PostMapping
    public Receita save(@RequestBody Receita receita) {
        Medico medico = medicoService.findById(receita.getMedico().getId());
        if (medico == null) {
            throw new IllegalArgumentException("ID do médico inválido");
        }

        Farmacia farmacia = farmaciaService.findById(receita.getFarmacia().getId());
        if (farmacia == null) {
            throw new IllegalArgumentException("ID da farmácia inválido");
        }

        receita.setMedico(medico);
        receita.setFarmacia(farmacia);
        return receitaService.save(receita);
    }

    @PutMapping("/{id}")
    public Receita update(@PathVariable Long id, @RequestBody Receita receita) {
        Receita existingReceita = receitaService.findById(id);
        if (existingReceita == null) {
            throw new IllegalArgumentException("ID da receita inválido");
        }

        Medico medico = medicoService.findById(receita.getMedico().getId());
        if (medico == null) {
            throw new IllegalArgumentException("ID do médico inválido");
        }

        Farmacia farmacia = farmaciaService.findById(receita.getFarmacia().getId());
        if (farmacia == null) {
            throw new IllegalArgumentException("ID da farmácia inválido");
        }

        receita.setId(id);
        receita.setMedico(medico);
        receita.setFarmacia(farmacia);
        return receitaService.save(receita);
    }

 
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        receitaService.deleteById(id);
    }
}
