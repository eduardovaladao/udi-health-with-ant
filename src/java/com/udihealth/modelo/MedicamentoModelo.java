package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.Medicamento;

public class MedicamentoModelo {

    public MedicamentoModelo() {
    }

    public static void inserirMedicamento(Medicamento med) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String query = "INSERT INTO MEDICAMENTO"
                    + "(nome)"
                    + "VALUES (?)";

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, med.getNome());

            pstm.executeUpdate();
            System.out.println("Novo medicamento inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public static ArrayList<Medicamento> buscarMedicamentos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Medicamento> medicamentos = new ArrayList<>();

        try {
            String query = "SELECT * FROM MEDICAMENTO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {
                Medicamento medicamento = new Medicamento(
                        resultado.getInt("cod_medicamento"),
                        resultado.getString("nome")
                );

                medicamentos.add(medicamento);
                System.out.println(medicamento);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco. " + err.getSQLState());
        }
        return medicamentos;
    }
    
    public static Medicamento buscarMedicamentoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();
        
        Medicamento medicamento = new Medicamento();
        
        try {
            String query = "SELECT * FROM MEDICAMENTO "
                    + "WHERE cod_medicamento = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(query);
            
            while (resultado.next()) {
                medicamento = new Medicamento(
                        resultado.getInt("cod_medicamento"),
                        resultado.getString("nome")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco. " + err.getSQLState());
        }
        
        return medicamento;
    }
    
    public static void imprimirMedicamentos(ArrayList<Medicamento> medicamentos) {
        System.out.println("Medicamentos:");
        for (Medicamento med : medicamentos) {
            System.out.println(med.toString());
        }
    }
    
    public static void main(String[] args) {
        Medicamento med = new Medicamento(
                1,
                "Atenelol"
        );
        
        inserirMedicamento(med);
        ArrayList<Medicamento> medicametos = buscarMedicamentos();
        System.out.println(buscarMedicamentoCodigo(1));
        imprimirMedicamentos(medicametos);
    }
}
