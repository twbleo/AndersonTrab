package com.springproj.demo.service;

import com.springproj.demo.model.Receita;
import com.springproj.demo.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<Receita> findAll() {
        return receitaRepository.findAll();
    }

    public Receita findById(Long id) {
        return receitaRepository.findById(id).orElse(null);
    }

    public Receita save(Receita receita) {
        return receitaRepository.save(receita);
    }

    public void deleteById(Long id) {
        receitaRepository.deleteById(id);
    }
}
