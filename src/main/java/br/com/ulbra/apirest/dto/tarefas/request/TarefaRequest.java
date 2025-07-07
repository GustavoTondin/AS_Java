package br.com.ulbra.apirest.dto.tarefas.request;

public class TarefaRequest {
    private Long userId;
    private String task;

    public TarefaRequest(){}

    public TarefaRequest(Long userId, String task) {
        this.userId = userId;
        this.task = task;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
