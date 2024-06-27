package com.springproj.demo.controller;

import com.springproj.demo.model.Medico;
import com.springproj.demo.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<Medico> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @PostMapping
    public Medico save(@RequestBody Medico medico) {
        return medicoService.save(medico);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        medicoService.deleteById(id);
    }
}
