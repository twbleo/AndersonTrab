package com.springproj.demo.service;

import com.springproj.demo.model.Medico;
import com.springproj.demo.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Long id) {
        return medicoRepository.findById(id).orElse(null);
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }
}
