package br.com.ulbra.apirest.controllers;

import br.com.ulbra.apirest.dto.tarefas.request.TarefaRequest;
import br.com.ulbra.apirest.dto.tarefas.response.TarefaResponseDTO;
import br.com.ulbra.apirest.entities.Tarefa;
import br.com.ulbra.apirest.entities.User;
import br.com.ulbra.apirest.services.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }
    @GetMapping
    public List<TarefaResponseDTO> getTarefas(){
        return this.tarefaService.getTarefas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> getTarefa(@PathVariable Long id) {
        return ResponseEntity.ok(this.tarefaService.getTarefa(id));
    }

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody TarefaRequest tarefaRequest){
        Tarefa tarefa = this.tarefaService.createTarefa(tarefaRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(tarefa.getId()).toUri();
        return ResponseEntity.created(uri).body(tarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTarefa(@PathVariable Long id) {
        this.tarefaService.deleteTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateUser(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        Tarefa updatedTarefa = this.tarefaService.updateTarefa(id, tarefa);
        return ResponseEntity.ok(updatedTarefa);
    }
}
