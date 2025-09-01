package com.arquitetura_limpa.Atividade.adapters.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private Float rendaMensal;
    private String dataNascimento;
    private String profissao;
}