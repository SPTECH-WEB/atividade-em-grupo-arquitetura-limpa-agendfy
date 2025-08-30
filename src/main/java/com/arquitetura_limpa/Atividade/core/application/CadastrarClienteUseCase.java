package com.arquitetura_limpa.Atividade.core.application;

import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteCreateDTO;
import com.arquitetura_limpa.Atividade.adapters.out.ClienteRepository;
import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Email;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Idade;
import com.arquitetura_limpa.Atividade.core.domain.ValueObjects.Telefone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastrarClienteUseCase {

    private final ClienteRepository clienteRepository;


    public Cliente cadastrarCliente(Cliente cliente) {
        return clienteRepository.salvar(cliente);
    }
}