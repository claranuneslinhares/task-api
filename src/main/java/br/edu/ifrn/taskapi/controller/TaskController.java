package br.edu.ifrn.taskapi.controller;

import br.edu.ifrn.taskapi.model.Task;
import br.edu.ifrn.taskapi.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarefas")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> criar(
            @RequestBody Map<String, String> corpo
    ) {

        System.out.println(
                "[CONTROLLER] Requisição recebida: POST /tarefas"
        );

        String titulo = corpo.get("titulo");
        String descricao = corpo.get("descricao");

        LocalDate prazo = null;

        if (corpo.get("prazo") != null &&
                !corpo.get("prazo").isBlank()) {

            prazo = LocalDate.parse(corpo.get("prazo"));
        }

        Task task = service.criar(
                titulo,
                descricao,
                prazo
        );

        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> listar() {

        System.out.println(
                "[CONTROLLER] Requisição recebida: GET /tarefas"
        );

        return ResponseEntity.ok(
                service.listar()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> buscar(
            @PathVariable Long id
    ) {

        System.out.println(
                "[CONTROLLER] Requisição recebida: GET /tarefas/"
                        + id
        );

        return ResponseEntity.ok(
                service.buscarPorId(id)
        );
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Task> concluir(
            @PathVariable Long id
    ) {

        System.out.println(
                "[CONTROLLER] Requisição recebida: PUT /tarefas/"
                        + id
                        + "/concluir"
        );

        return ResponseEntity.ok(
                service.concluir(id)
        );
    }
}