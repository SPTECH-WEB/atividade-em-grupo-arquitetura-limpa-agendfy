package com.arquitetura_limpa.Atividade.adapters.in;


import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteCreateDTO;
import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteResponseDTO;
import com.arquitetura_limpa.Atividade.adapters.out.mapper.ClienteDTOMapper;
import com.arquitetura_limpa.Atividade.adapters.out.mapper.ClienteMapper;
import com.arquitetura_limpa.Atividade.adapters.out.persistence.ClienteEntity;
import com.arquitetura_limpa.Atividade.core.application.CadastrarClienteUseCase;
import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final ClienteMapper clienteMapper;
    private final ClienteDTOMapper clienteDTOMapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> create(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        // DTO -> Domain
        Cliente cliente = clienteDTOMapper.toDomain(clienteCreateDTO);

        // Chama o use case (retorna Domain)
        Cliente clienteSalvo = cadastrarClienteUseCase.cadastrarCliente(cliente);

        // Domain -> ResponseDTO
        ClienteResponseDTO responseDTO = clienteDTOMapper.toResponseDTO(clienteSalvo);

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
