package com.arquitetura_limpa.Atividade.core.application;

import com.arquitetura_limpa.Atividade.adapters.out.ClienteRepository;
import com.arquitetura_limpa.Atividade.adapters.out.persistence.ClienteEntity;
import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import com.arquitetura_limpa.Atividade.core.mapper.ClienteMapperManual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CadastrarClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final ClienteMapperManual clienteMapper;

    @Autowired
    public CadastrarClienteUseCase(ClienteRepository clienteRepository, ClienteMapperManual clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteMapper.toEntity(cliente);
        ClienteEntity savedEntity = clienteRepository.save(clienteEntity);
        return clienteMapper.toDomain(savedEntity);
    }

    public Cliente obterClientePorId(UUID id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return clienteMapper.toDomain(clienteEntity);
    }
}