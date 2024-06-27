package com.springproj.demo.controller;

import com.springproj.demo.model.Farmacia;
import com.springproj.demo.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping
    public List<Farmacia> findAll() {
        return farmaciaService.findAll();
    }

    @GetMapping("/{id}")
    public Farmacia findById(@PathVariable Long id) {
        return farmaciaService.findById(id);
    }

    @PostMapping
    public Farmacia save(@RequestBody Farmacia farmacia) {
        return farmaciaService.save(farmacia);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        farmaciaService.deleteById(id);
    }
}
