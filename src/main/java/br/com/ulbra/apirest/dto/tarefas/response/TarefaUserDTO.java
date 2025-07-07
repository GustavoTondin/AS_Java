package br.com.ulbra.apirest.dto.tarefas.response;

public class TarefaUserDTO {
    private String name;

    public TarefaUserDTO(){}

    public TarefaUserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
