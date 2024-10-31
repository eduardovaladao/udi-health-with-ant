package com.udihealth.dominio;

import java.util.ArrayList;

public class Medicamento {

    private Integer codigo;

    private String nome;
    
    private ArrayList<MedicamentoPrescrito> medicamentosPrescritos;

    public Medicamento() {
    }

    public Medicamento(Integer codigo, String nome) {
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

    public ArrayList<MedicamentoPrescrito> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(ArrayList<MedicamentoPrescrito> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    @Override
    public String toString() {
        return "Medicamento{" + "codigo=" + codigo + ", nome=" + nome + ", medicamentosPrescritos=" + medicamentosPrescritos + '}';
    }
}
