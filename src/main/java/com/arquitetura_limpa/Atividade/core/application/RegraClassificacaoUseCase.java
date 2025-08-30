package com.arquitetura_limpa.Atividade.core.application;

import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import org.springframework.stereotype.Service;

@Service
public class RegraClassificacaoUseCase {

    public String classificarRisco(Cliente cliente) {
        if (cliente.getRendaMensal() < 3000) {
            return "ALTO";
        } else if (cliente.getRendaMensal() >= 3000 && cliente.getRendaMensal() < 6000 || cliente.getIdade() <= 30) {
            return "MÉDIO";
        } else {
            return "BAIXO";
        }
    }
}
