package com.udihealth.dominio;

import com.udihealth.dominio.Consulta;
import java.util.ArrayList;
import java.sql.Date;

public class Medico extends Usuario {

    private Integer codigoMedico;

    private String crm;

    private ArrayList<Consulta> consultas;
    

    public Medico() {
    } // construtor vazio

    //construtor de Medico + atributos de Usuario
    public Medico(Integer codigoMedico, String crm, Integer codigoUsuario, String nome, String senha, Date dataNascimento, Character sexo, String cpf, String cep, String telefone, String email, Status status) {
        super(codigoUsuario, nome, senha, dataNascimento, sexo, cpf, cep, telefone, email, status);
        this.codigoMedico = codigoMedico;
        this.crm = crm;
    }
    

    public Integer getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(Integer codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public ArrayList<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas) {
        this.consultas = consultas;
    }

    @Override
    public String toString() {
        return "Medico{" + "codigoMedico=" + codigoMedico + ", crm=" + crm + ", consultas=" + consultas + '}';
    }
}
