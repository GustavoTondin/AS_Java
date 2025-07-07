package br.com.ulbra.apirest.dto.tarefas.response;

public class TarefaResponseDTO {
    private String task;
    private TarefaUserDTO user;

    public TarefaResponseDTO() {}

    public TarefaResponseDTO(String task, TarefaUserDTO user) {
        this.task = task;
        this.user = user;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public TarefaUserDTO getUser() {
        return user;
    }

    public void setUser(TarefaUserDTO user) {
        this.user = user;
    }
}
