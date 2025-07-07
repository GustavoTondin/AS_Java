package br.com.ulbra.apirest.dto.users;

public class UserTarefaDTO {
    private String task;

    public UserTarefaDTO(String task) {
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
