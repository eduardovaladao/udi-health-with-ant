package com.udihealth.dominio;

import com.udihealth.dominio.Consulta;

public class MedicamentoPrescrito {
    // identificador
    private Integer codigo;
    
    // os objetos relacionados vêm primeiro
    private Medicamento medicamento;
    
    private Consulta consulta;

    private String posologia;
    public MedicamentoPrescrito() {
    }

    public MedicamentoPrescrito(Integer codigo, Medicamento medicamento, Consulta consulta, String posologia) {
        this.codigo = codigo;
        this.medicamento = medicamento;
        this.consulta = consulta;
        this.posologia = posologia;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    @Override
    public String toString() {
        return "MedicamentoPrescrito{" + "codigo=" + codigo +", medicamento=" + medicamento + ", consulta=" + consulta +  ", posologia=" + posologia + '}';
    }
}
