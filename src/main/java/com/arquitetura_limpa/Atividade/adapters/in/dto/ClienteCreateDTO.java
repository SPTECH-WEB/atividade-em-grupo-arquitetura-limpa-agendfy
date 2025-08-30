package com.arquitetura_limpa.Atividade.adapters.in.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteCreateDTO {

    @NotNull
    public String nome;

    @NotNull
    @Email
    public String email;

    @NotNull
    public String telefone;

    @NotNull
    public String cpf;

    @NotNull
    public Float rendaMensal;

    @NotNull
    public String dataNascimento;

    @NotNull
    public String profissao;
}
