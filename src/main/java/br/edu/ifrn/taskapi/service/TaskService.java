package br.edu.ifrn.taskapi.service;

import br.edu.ifrn.taskapi.model.Task;
import br.edu.ifrn.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task criar(
            String titulo,
            String descricao,
            LocalDate prazo
    ) {

        System.out.println(
                "[SERVICE] Validando regra de negócio para: "
                        + titulo
        );

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException(
                    "O título da tarefa não pode ser vazio."
            );
        }

        return repository.salvar(
                titulo.trim(),
                descricao,
                prazo
        );
    }

    public List<Task> listar() {

        System.out.println(
                "[SERVICE] Solicitando lista de tarefas ao repository"
        );

        return repository.listarTodas();
    }

    public Task buscarPorId(Long id) {

        System.out.println(
                "[SERVICE] Processando busca por id: "
                        + id
        );

        return repository.buscarPorId(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Tarefa não encontrada: " + id
                        )
                );
    }

    public Task concluir(Long id) {

        System.out.println(
                "[SERVICE] Concluindo tarefa: "
                        + id
        );

        Task task = buscarPorId(id);

        task.setConcluida(true);

        return task;
    }
}