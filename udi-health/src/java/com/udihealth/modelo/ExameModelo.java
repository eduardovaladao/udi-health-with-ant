package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.Exame;

public class ExameModelo {

    public ExameModelo() {
    }

    public static void inserirExame(Exame ex) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String query = "INSERT INTO EXAME"
                    + "(nome) "
                    + "VALUES (?)";

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, ex.getNome());
            pstm.executeUpdate();
            System.out.println("Novo exame inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public static ArrayList<Exame> buscarExames() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Exame> exames = new ArrayList<>();

        try {
            String query = "SELECT * FROM EXAME";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);
            
            while (resultado.next()) {
                Exame exame = new Exame(
                        resultado.getInt("cod_exame"),
                        resultado.getString("nome")
                );

                exames.add(exame);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco. " + err.getSQLState());
        }
        return exames;
    }

    public static Exame buscarExameCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Exame exame = new Exame();

        try {
            String consulta = "SELECT * FROM EXAME "
                    + "WHERE cod_exame = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                exame = new Exame(
                        resultado.getInt("cod_exame"),
                        resultado.getString("nome")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta ao banco. " + err.getSQLState());
        }
        return exame;
    }

    public static void imprimirExames(ArrayList<Exame> exames) {
        System.out.println("Exames:\n");
        for (Exame ex : exames) {
            System.out.println(ex.toString());
        }
    }

    public static void main(String[] args) {        
        Exame exame = new Exame(
                1,
                "Hemograma"
        );

        inserirExame(exame);
        
        ArrayList<Exame> exames = buscarExames();
        
        System.out.println(buscarExameCodigo(1));
        imprimirExames(exames);
        System.out.println("Ok");
    }
}
