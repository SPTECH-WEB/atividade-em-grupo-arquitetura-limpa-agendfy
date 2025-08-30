package com.arquitetura_limpa.Atividade.adapters.in;

import com.arquitetura_limpa.Atividade.core.application.CadastrarClienteUseCase;
import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteCreateDTO;
import com.arquitetura_limpa.Atividade.core.domain.Cliente;
import com.arquitetura_limpa.Atividade.core.mapper.ClienteMapperManual;
import com.arquitetura_limpa.Atividade.core.application.RegraClassificacaoUseCase;
import com.arquitetura_limpa.Atividade.adapters.in.dto.ClienteResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CadastrarClienteUseCase cadastrarClienteUseCase;
    private final ClienteMapperManual clienteMapper;
    private final RegraClassificacaoUseCase regraClassificacaoUseCase;

    @Autowired
    public ClienteController(CadastrarClienteUseCase cadastrarClienteUseCase, ClienteMapperManual clienteMapper, RegraClassificacaoUseCase regraClassificacaoUseCase) {
        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.clienteMapper = clienteMapper;
        this.regraClassificacaoUseCase = regraClassificacaoUseCase;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody ClienteCreateDTO clienteCreateDTO) {
        Cliente cliente = clienteMapper.toDomain(clienteCreateDTO);
        Cliente clienteCadastrado = cadastrarClienteUseCase.cadastrarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> obterClientePorId(@PathVariable UUID id) {
        Cliente cliente = cadastrarClienteUseCase.obterClientePorId(id);
        String classificacao = regraClassificacaoUseCase.classificarRisco(cliente);
        String sugestaoContato = gerarSugestaoContato(classificacao);
        int idade = 0;
        if (cliente.getDataNascimento() != null) {
            idade = Period.between(cliente.getDataNascimento(), LocalDate.now()).getYears();
        }
        ClienteResponseDTO response = new ClienteResponseDTO(
            cliente.getId().toString(),
            cliente.getNome(),
            cliente.getEmail().getEmail(),
            cliente.getTelefone().getTelefone(),
            cliente.getCpf(),
            cliente.getRendaMensal(),
            idade,
            cliente.getProfissao(),
            classificacao,
            sugestaoContato
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/classificacao")
    public ResponseEntity<String> obterClassificacao(@PathVariable UUID id) {
        Cliente cliente = cadastrarClienteUseCase.obterClientePorId(id);
        String classificacao = regraClassificacaoUseCase.classificarRisco(cliente);
        String sugestaoContato = gerarSugestaoContato(classificacao);
        return ResponseEntity.ok("Classificação: " + classificacao + ", Sugestão de contato: " + sugestaoContato);
    }

    private String gerarSugestaoContato(String classificacao) {
        switch (classificacao.toUpperCase()) {
            case "ALTO":
                return "Contato automático por e-mail.";
            case "MÉDIO":
                return "Análise manual em até 48h.";
            case "BAIXO":
                return "Contato telefônico em até 24h + análise crítica.";
            default:
                return "Classificação desconhecida. Avaliar manualmente.";
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgumentException(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
