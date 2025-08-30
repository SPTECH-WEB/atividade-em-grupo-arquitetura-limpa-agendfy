package com.arquitetura_limpa.Atividade.adapters.out;

import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente salvar(Cliente cliente);
}
