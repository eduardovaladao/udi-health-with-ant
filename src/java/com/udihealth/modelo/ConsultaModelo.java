package com.udihealth.modelo;

import java.sql.*;
import java.util.ArrayList;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.Consulta;

public class ConsultaModelo {

    public ConsultaModelo() {
    }

    public static ArrayList<Consulta> buscarConsultas() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Consulta> consultas = new ArrayList<>();

        try {
            String query = "SELECT * FROM CONSULTA";

            Statement stm = conexao.createStatement();

            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {

                Consulta consulta = new Consulta(
                        resultado.getInt("cod_consulta"),
                        resultado.getDate("data"),
                        resultado.getTime("horario"),
                        resultado.getString("diagnostico"),
                        resultado.getString("indicacao"),
                        MedicoModelo.buscarMedicoCodigo(resultado.getInt("cod_medico")),
                        PacienteModelo.buscarPacienteCodigo(resultado.getInt("cod_paciente"))
                );

                consultas.add(consulta);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco.");
        }

        return consultas;
    }

    public static Consulta buscarConsultaCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Consulta consulta = new Consulta();

        try {
            String query = "SELECT * FROM CONSULTA "
                    + "WHERE cod_consulta = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {

                consulta.setCodigo(resultado.getInt("cod_consulta"));

                consulta.setData(resultado.getDate("data"));

                consulta.setHorario(resultado.getTime("horario"));

                consulta.setDiagnostico(resultado.getString("diagnostico"));

                consulta.setIndicacao(resultado.getString("indicacao"));

                consulta.setMedico(MedicoModelo.buscarMedicoCodigo(resultado.getInt("cod_medico")));
                consulta.setPaciente(PacienteModelo.buscarPacienteCodigo(resultado.getInt("cod_paciente")));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível consultar a tabela");
        }

        return consulta;
    }

    public static void inserirConsulta(Consulta cst) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO CONSULTA"
                    + "(data, horario, diagnostico, indicacao, cod_paciente, cod_medico)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(consulta);

            pstm.setDate(1, cst.getData());
            pstm.setTime(2, cst.getHorario());
            pstm.setString(3, cst.getDiagnostico());
            pstm.setString(4, cst.getIndicacao());
            pstm.setInt(5, cst.getPaciente().getCodigoPaciente());
            pstm.setInt(6, cst.getMedico().getCodigoMedico());

            pstm.executeUpdate();
            System.out.println("Nova consulta registrada!");

        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public static void atualizarConsulta(int codigo, Consulta c) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        String query = "UPDATE CONSULTA "
                + "SET data = '" + c.getData() + "', "
                + "horario = '" + c.getHorario() + "', "
                + "diagnostico = '" + c.getDiagnostico() + "', "
                + "indicacao = '" + c.getIndicacao() + "' "
                + "WHERE cod_consulta = " + c.getCodigo();
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();
            System.out.println("Consulta atualizada!");
        } catch (SQLException err) {
            System.err.println("Não foi possível atualizar a consulta. " + err);
        }
    }

    public static void deletarConsulta(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        String delete = "DELETE FROM CONSULTA "
                + "WHERE cod_consulta = " + codigo;
        try {
            PreparedStatement pstm = con.prepareStatement(delete);
            pstm.executeUpdate();
            pstm.close();
            System.out.println("Consulta deletada!!!");
        } catch (SQLException err) {
            System.err.println("A consulta não foi deletada. " + err);
        }
    }

    public static void imprimirConsulta(ArrayList<Consulta> array) {
        System.out.println("Consulta:");
        for (Consulta cst : array) {
            System.out.println(cst.toString());
        }
    }

    public static void main(String[] args) {
        Consulta consulta = new Consulta(
                1,
                Date.valueOf("2060-07-19"),
                Time.valueOf("16:45:00"),
                "Indefinido",
                null,
                MedicoModelo.buscarMedicoCodigo(1),
                PacienteModelo.buscarPacienteCodigo(1)
        );

        //inserirConsulta(novaConsulta);
        ArrayList<Consulta> consultas = buscarConsultas();

        imprimirConsulta(consultas);

        deletarConsulta(1);

        System.out.println("Ok");

    }
}
