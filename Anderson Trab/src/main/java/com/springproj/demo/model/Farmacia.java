package com.springproj.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não deve estar em branco")
    private String nome;

    @NotBlank(message = "O CNPJ não deve estar em branco")
    private String cnpj;

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
