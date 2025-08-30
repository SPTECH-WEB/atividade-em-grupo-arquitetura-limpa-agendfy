package com.arquitetura_limpa.Atividade.adapters.out.mapper;
import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteCreateDTO;
import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteResponseDTO;
import com.arquitetura_limpa.Atividade.adapters.out.persistence.ClienteEntity;
import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toDomain(ClienteCreateDTO dto);

    ClienteCreateDTO toDTO(Cliente cliente);

    ClienteEntity toEntity(Cliente cliente);

    Cliente toDomain(ClienteEntity entity);


//    @Mapping(target = "email", expression = "java(cliente.getEmail().getValue())")
//    @Mapping(target = "telefone", expression = "java(cliente.getTelefone().getNumero())")
//    @Mapping(target = "idade", expression = "java(cliente.getIdade().getValor())")
    ClienteResponseDTO toResponseDTO(ClienteEntity entity);

}
