package com.arquitetura_limpa.Atividade.core.domain;

import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Email;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Idade;

import java.util.UUID;

public class Cliente {

    private UUID id;
    private String nome;
    private Email email;
    private String telefone;
    private String cpf;
    private Float rendaMensal;
    private Idade idade;
    private String profissao;

    public Cliente(UUID id, String nome, Email email, String telefone, String cpf, Float rendaMensal, Idade idade, String profissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.rendaMensal = rendaMensal;
        this.idade = idade;
        this.profissao = profissao;
    }
}
