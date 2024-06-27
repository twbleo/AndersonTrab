package com.springproj.demo.service;

import com.springproj.demo.model.Farmacia;
import com.springproj.demo.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    public List<Farmacia> findAll() {
        return farmaciaRepository.findAll();
    }

    public Farmacia findById(Long id) {
        return farmaciaRepository.findById(id).orElse(null);
    }

    public Farmacia save(Farmacia farmacia) {
        return farmaciaRepository.save(farmacia);
    }

    public void deleteById(Long id) {
        farmaciaRepository.deleteById(id);
    }
}
