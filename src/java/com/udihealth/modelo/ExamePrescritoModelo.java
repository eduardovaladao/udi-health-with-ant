package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.ExamePrescrito;

public class ExamePrescritoModelo {

    public ExamePrescritoModelo() {
    }

    public static void inserirExamePrescrito(ExamePrescrito exp) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO EXAME_PRESCRITO"
                    + "(cod_exame_prescrito, cod_exame, cod_consulta, data_realizacao, horario_realizacao, resultado)"
                    + "VALUES (?, ?, ?, ?, ?, ?) ";

            PreparedStatement pstm = con.prepareStatement(consulta);

            pstm.setInt(1, exp.getCodigo());
            pstm.setInt(2, exp.getExame().getCodigo());
            pstm.setInt(3, exp.getConsulta().getCodigo());
            pstm.setDate(4, exp.getDataRealizacao());
            pstm.setTime(5, exp.getHorarioRealizacao());
            pstm.setString(6, exp.getResultado());

            pstm.executeUpdate();
            System.out.println("Novo exame prescrito inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public static ArrayList<ExamePrescrito> buscarExamesPrescritos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<ExamePrescrito> examesPrescritos = new ArrayList<>();
        ExamePrescrito examePrescrito;
        try {
            String consulta = "SELECT * FROM EXAME_PRESCRITO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                examePrescrito = new ExamePrescrito(
                        resultado.getInt("cod_exame_prescrito"),
                        ExameModelo.buscarExameCodigo(resultado.getInt("cod_exame")),
                        ConsultaModelo.buscarConsultaCodigo(resultado.getInt("cod_consulta")),
                        resultado.getDate("data_realizacao"),
                        resultado.getTime("horario_realizacao"),
                        resultado.getString("resultado")
                );

                examesPrescritos.add(examePrescrito);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco." + err.getSQLState());
        }
        return examesPrescritos;
    }

    public static ExamePrescrito buscarExamePrescritoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        ExamePrescrito examePrescrito = new ExamePrescrito();

        try {
            String consulta = "SELECT * FROM EXAME_PRESCRITO "
                    + "WHERE cod_exame_prescrito = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                examePrescrito = new ExamePrescrito(
                        resultado.getInt("cod_exame_prescrito"),
                        ExameModelo.buscarExameCodigo(resultado.getInt("cod_exame")),
                        ConsultaModelo.buscarConsultaCodigo(resultado.getInt("cod_consulta")),
                        resultado.getDate("data_realizacao"),
                        resultado.getTime("horario_realizacao"),
                        resultado.getString("resultado")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return examePrescrito;
    }

    public static void imprimirExamesPrescritos(ArrayList<ExamePrescrito> examesPrescritos) {
        System.out.println("Exames prescritos:\n");
        for (ExamePrescrito exp : examesPrescritos) {
            System.out.println(exp.toString());
        }
    }
    
    public static void main(String[] args) {
        ExamePrescrito exp = new ExamePrescrito(
                1,
                ExameModelo.buscarExameCodigo(2),
                ConsultaModelo.buscarConsultaCodigo(1),
                Date.valueOf("2020-09-08"),
                Time.valueOf("20:00:00"),
                "Infecção de sangue"
        );
        
        inserirExamePrescrito(exp);
        ArrayList<ExamePrescrito> examesPrescritos = buscarExamesPrescritos();
        
        System.out.println(buscarExamePrescritoCodigo(1));
        
        imprimirExamesPrescritos(examesPrescritos);
    }
}
