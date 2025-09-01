package com.arquitetura_limpa.Atividade.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDTO {
    public String id;
    public String nome;
    public String email;
    public String telefone;
    public String cpf;
    public Float rendaMensal;
    public Integer idade;
    public String profissao;
    public String classificacaoRisco;
    public String sugestaoContato;
}
