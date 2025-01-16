package com.udihealth.dominio;

import java.util.ArrayList;

public class Exame {

    private Integer codigo;

    private String nome;
    
    private ArrayList<ExamePrescrito> examesPrescritos;

    public Exame() {
    }

    public Exame(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ExamePrescrito> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void setExamesPrescritos(ArrayList<ExamePrescrito> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    @Override
    public String toString() {
        return "Exame{" + "codigo=" + codigo + ", nome=" + nome + ", examesPrescritos=" + examesPrescritos + '}';
    }
}
