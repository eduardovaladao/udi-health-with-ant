package com.udihealth.dominio;

import java.sql.Date;
import java.util.ArrayList;

public class Paciente extends Usuario {

    private Integer codigoPaciente;

    private String observacoes;

    private ArrayList<Consulta> consultas;

    public Paciente() {}

    public Paciente(Integer codigoPaciente, String observacoes, Integer codigoUsuario, String nome, String senha, Date dataNascimento, Character sexo, String cpf, String cep, String telefone, String email, Status status) {
        super(codigoUsuario, nome, senha, dataNascimento, sexo, cpf, cep, telefone, email, status);
        this.codigoPaciente = codigoPaciente;
        this.observacoes = observacoes;
    }

    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Paciente{" + super.toString() + "codigoPaciente=" + codigoPaciente + ", observacoes=" + observacoes + ", consultas=" + consultas + '}';
    }
}
