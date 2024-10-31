package com.udihealth.dominio;

import com.udihealth.dominio.Consulta;
import java.sql.Date;
import java.sql.Time;

// Classe Associativa
public class ExamePrescrito {

    // identificador
    private Integer codigo;

    // os objetos relacionados vêm primeiro
    private Exame exame;

    private Consulta consulta;

    private Date dataRealizacao;

    private Time horarioRealizacao;

    private String resultado;

    public ExamePrescrito() {
    }

    public ExamePrescrito(Integer codigo, Exame exame, Consulta consulta,  Date dataRealizacao, Time horarioRealizacao, String resultado) {
        this.codigo = codigo;
        this.exame = exame;
        this.consulta = consulta;
        this.dataRealizacao = dataRealizacao;
        this.horarioRealizacao = horarioRealizacao;
        this.resultado = resultado;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public Time getHorarioRealizacao() {
        return horarioRealizacao;
    }

    public void setHorarioRealizacao(Time horarioRealizacao) {
        this.horarioRealizacao = horarioRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "ExamePrescrito{" + "codigo=" + codigo + ", exame=" + exame + ", consulta=" + consulta + ", dataRealizacao=" + dataRealizacao + ", horarioRealizacao=" + horarioRealizacao + ", resultado=" + resultado + '}';
    }
}
