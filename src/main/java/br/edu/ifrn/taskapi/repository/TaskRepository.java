package br.edu.ifrn.taskapi.repository;

import br.edu.ifrn.taskapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private final Map<Long, Task> banco = new LinkedHashMap<>();

    private final AtomicLong sequencia = new AtomicLong();

    public Task salvar(Task task) {

        System.out.println(
                "[REPOSITORY] Salvando tarefa em memória: "
                        + task.getTitulo()
        );

        if (task.getId() == null) {
            task.setId(sequencia.incrementAndGet());
        }

        banco.put(task.getId(), task);

        return task;
    }

    public List<Task> listarTodas() {

        System.out.println(
                "[REPOSITORY] Buscando todas as tarefas em memória"
        );

        return new ArrayList<>(banco.values());
    }

    public Optional<Task> buscarPorId(Long id) {

        System.out.println(
                "[REPOSITORY] Buscando tarefa por id: " + id
        );

        return Optional.ofNullable(banco.get(id));
    }
}