package br.com.ulbra.apirest.services;

import br.com.ulbra.apirest.dto.tarefas.request.TarefaRequest;
import br.com.ulbra.apirest.dto.tarefas.response.TarefaResponseDTO;
import br.com.ulbra.apirest.dto.tarefas.response.TarefaUserDTO;
import br.com.ulbra.apirest.entities.Tarefa;
import br.com.ulbra.apirest.entities.User;
import br.com.ulbra.apirest.repositories.TarefaRepository;
import br.com.ulbra.apirest.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final UserRepository userRepository;

    public TarefaService(TarefaRepository tarefaRepository, UserRepository userRepository) {
        this.tarefaRepository = tarefaRepository;
        this.userRepository = userRepository;
    }

    public TarefaResponseDTO getTarefa(Long id) {
        Tarefa tarefa = this.tarefaRepository.findById(id)
                .orElseThrow();

        return new TarefaResponseDTO(
                tarefa.getTask(),
                new TarefaUserDTO(tarefa.getUser().getName())
        );
    }

    public List<TarefaResponseDTO> getTarefas() {
        return this.tarefaRepository.findAll()
                .stream()
                .map(item ->
                        new TarefaResponseDTO(
                                item.getTask(),
                                new TarefaUserDTO(item.getUser().getName())
                        )).collect(Collectors.toList());
    }

    public Tarefa createTarefa(TarefaRequest tarefaRequest) {
        User user = userRepository.findById(tarefaRequest.getUserId()).orElseThrow();

        Tarefa tarefa = new Tarefa();
        tarefa.setTask(tarefaRequest.getTask());
        tarefa.setUser(user);

        return tarefaRepository.save(tarefa);
    }

    public void deleteTarefa(Long id) {
        Tarefa tarefa = this.tarefaRepository.findById(id).orElseThrow();
        this.tarefaRepository.delete(tarefa);
    }

    public Tarefa updateTarefa(Long id, Tarefa tarefaRequest) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrado"));

        tarefa.setTask(tarefaRequest.getTask());
        return tarefaRepository.save(tarefa);
    }
}
