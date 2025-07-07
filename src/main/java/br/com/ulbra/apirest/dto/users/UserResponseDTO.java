package br.com.ulbra.apirest.dto.users;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<UserTarefaDTO> tarefas = new ArrayList<>();

    public UserResponseDTO(Long id,String name, String email, List<UserTarefaDTO> tarefas) {
        this.name = name;
        this.email = email;
        this.tarefas = tarefas;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<UserTarefaDTO> getTarefas() {
        return tarefas;
    }

    public void setPosts(List<UserTarefaDTO> tarefas) {
        this.tarefas = tarefas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
