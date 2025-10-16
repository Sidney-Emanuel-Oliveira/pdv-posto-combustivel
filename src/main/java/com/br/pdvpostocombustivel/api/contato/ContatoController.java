package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
@Tag(name = "Contatos", description = "Operações relacionadas a contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @Operation(summary = "Criar novo contato", description = "Cria um novo contato no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Contato criado com sucesso",
            content = @Content(schema = @Schema(implementation = ContatoResponse.class))),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ContatoResponse> criar(@Valid @RequestBody ContatoRequest request) {
        ContatoResponse response = contatoService.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar contato por ID", description = "Retorna um contato específico pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato encontrado",
            content = @Content(schema = @Schema(implementation = ContatoResponse.class))),
        @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public ResponseEntity<ContatoResponse> buscarPorId(
            @Parameter(description = "ID do contato") @PathVariable Long id) {
        return ResponseEntity.ok(contatoService.buscarPorId(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os contatos", description = "Retorna uma lista com todos os contatos")
    @ApiResponse(responseCode = "200", description = "Lista de contatos retornada com sucesso",
        content = @Content(schema = @Schema(implementation = ContatoResponse.class)))
    public ResponseEntity<List<ContatoResponse>> listarTodos() {
        return ResponseEntity.ok(contatoService.listarTodos());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar contato", description = "Atualiza um contato existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso",
            content = @Content(schema = @Schema(implementation = ContatoResponse.class))),
        @ApiResponse(responseCode = "404", description = "Contato não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<ContatoResponse> atualizar(
            @Parameter(description = "ID do contato") @PathVariable Long id,
            @Valid @RequestBody ContatoRequest request) {
        return ResponseEntity.ok(contatoService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar contato", description = "Remove um contato do sistema pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Contato deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Contato não encontrado")
    })
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do contato") @PathVariable Long id) {
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
