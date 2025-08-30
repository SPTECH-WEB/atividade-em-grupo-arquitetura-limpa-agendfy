package com.arquitetura_limpa.Atividade.adapters.out.mapper;

import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteCreateDTO;
import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteResponseDTO;
import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteDTOMapper {


        Cliente toDomain(ClienteCreateDTO dto);


//    @Mapping(target = "email", expression = "java(cliente.getEmail().getValue())")
//    @Mapping(target = "telefone", expression = "java(cliente.getTelefone().getNumero())")
//    @Mapping(target = "idade", expression = "java(cliente.getIdade().getValor())")
        ClienteResponseDTO toResponseDTO(Cliente cliente);
    }


