package br.edu.ifrn.taskapi.model;

import java.time.LocalDate;

public class Task {

    private Long id;
    private String titulo;
    private String descricao;
    private LocalDate prazo;
    private boolean concluida;
    private String prioridade;

    public Task(Long id, String titulo, String descricao,
                LocalDate prazo, boolean concluida) {

        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = concluida;
    }

    public Task(String titulo, String descricao, LocalDate prazo) {
        this(null, titulo, descricao, prazo, false);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}