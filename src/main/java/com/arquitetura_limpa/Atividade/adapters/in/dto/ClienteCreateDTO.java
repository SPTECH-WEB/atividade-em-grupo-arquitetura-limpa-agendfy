package com.arquitetura_limpa.Atividade.adapters.in.dto;

import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Email;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Idade;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Telefone;
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
    public Email email;

    @NotNull
    public Telefone telefone;

    @NotNull
    public String cpf;

    @NotNull
    public Float rendaMensal;

    @NotNull
    public Idade idade;

    @NotNull
    public String profissao;

}
