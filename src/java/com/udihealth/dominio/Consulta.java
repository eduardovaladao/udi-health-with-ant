package com.udihealth.dominio;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class Consulta {

    private Integer codigo;

    private Date data;

    private Time horario;
    
    private String diagnostico;
    
    private String indicacao;

    private Medico medico;

    private Paciente paciente;
    
    private ArrayList<MedicamentoPrescrito> medicamentosPrescritos;
    
    private ArrayList<ExamePrescrito> examesPrescritos;

    public Consulta() {
    }

    public Consulta(Integer codigo, Date data, Time horario, String diagnostico, String indicacao, Medico medico, Paciente paciente) {
        this.codigo = codigo;
        this.data = data;
        this.horario = horario;
        this.diagnostico = diagnostico;
        this.indicacao = indicacao;
        this.medico = medico;
        this.paciente = paciente;
    }

    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public ArrayList<MedicamentoPrescrito> getMedicamentosPrescritos() {
        return medicamentosPrescritos;
    }

    public void setMedicamentosPrescritos(ArrayList<MedicamentoPrescrito> medicamentosPrescritos) {
        this.medicamentosPrescritos = medicamentosPrescritos;
    }

    public ArrayList<ExamePrescrito> getExamesPrescritos() {
        return examesPrescritos;
    }

    public void setExamesPrescritos(ArrayList<ExamePrescrito> examesPrescritos) {
        this.examesPrescritos = examesPrescritos;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Consulta{" + "codigo=" + codigo + ", data=" + data + ", horario=" + horario + ", diagnostico=" + diagnostico + ", indicacao=" + indicacao + ", medico=" + medico + ", paciente=" + paciente + ", medicamentosPrescritos=" + medicamentosPrescritos + ", examesPrescritos=" + examesPrescritos + '}';
    }
}
