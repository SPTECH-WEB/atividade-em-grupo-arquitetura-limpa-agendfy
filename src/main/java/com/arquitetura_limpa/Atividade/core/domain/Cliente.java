package com.arquitetura_limpa.Atividade.core.domain;

import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Email;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Telefone;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nome;
    private Telefone telefone;
    private Email email;
    private String cpf;
    private Float rendaMensal;
    private LocalDate dataNascimento;
    private String profissao;

    public Cliente() {
    }

    public Cliente(UUID id, String nome, Email email, Telefone telefone, String cpf, Float rendaMensal, LocalDate dataNascimento, String profissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.dataNascimento = dataNascimento;
        this.profissao = profissao;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Email getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Float getRendaMensal() {
        return rendaMensal;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - this.dataNascimento.getYear();
    }
}
