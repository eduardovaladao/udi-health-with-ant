package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.MedicamentoPrescrito;

public class MedicamentoPrescritoModelo {

    public MedicamentoPrescritoModelo() {
    }

    public static void inserirMedicamentoPrescrito(MedicamentoPrescrito medp) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO MEDICAMENTO_PRESCRITO"
                    + "(cod_consulta, cod_medicamento, posologia)"
                    + "VALUES (?, ?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setInt(1, medp.getConsulta().getCodigo());
            pstm.setInt(2, medp.getMedicamento().getCodigo());
            pstm.setString(3, medp.getPosologia());

            pstm.executeUpdate();
            System.out.println("Novo medicamento prescrito inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public static ArrayList<MedicamentoPrescrito> buscarMedicamentosPrescritos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<MedicamentoPrescrito> medicamentosPrescritos = new ArrayList<>();

        try {
            String query = "SELECT * FROM MEDICAMENTO_PRESCRITO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {
                MedicamentoPrescrito medicamentoPrescrito = new MedicamentoPrescrito(
                        resultado.getInt("cod_medicamento_prescrito"),
                        MedicamentoModelo.buscarMedicamentoCodigo(resultado.getInt("cod_medicamento")),
                        ConsultaModelo.buscarConsultaCodigo(resultado.getInt("cod_consulta")),
                        resultado.getString("posologia")
                );

                medicamentosPrescritos.add(medicamentoPrescrito);
                System.out.println(medicamentosPrescritos);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return medicamentosPrescritos;
    }

    public static MedicamentoPrescrito buscarMedicamentoPrescritoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        MedicamentoPrescrito medicamentoPrescrito = new MedicamentoPrescrito();

        try {
            String consulta = "SELECT * FROM MEDICAMENTO_PRESCRITO "
                    + "WHERE cod_medicamento_prescrito = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);
            while (resultado.next()) {
                medicamentoPrescrito = new MedicamentoPrescrito(
                        resultado.getInt("cod_medicamento_prescrito"),
                        MedicamentoModelo.buscarMedicamentoCodigo(resultado.getInt("cod_medicamento")),
                        ConsultaModelo.buscarConsultaCodigo(resultado.getInt("cod_consulta")),
                        resultado.getString("posologia")
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return medicamentoPrescrito;
    }

    public static void imprimirMedicamentosPrescritos(ArrayList<MedicamentoPrescrito> medicamentosPrescritos) {
        System.out.println("Medicamento Prescritos:\n");
        for (MedicamentoPrescrito medp : medicamentosPrescritos) {
            System.out.println(medp.toString());
        }
    }

    public static void main(String[] args) {        
        MedicamentoPrescrito medicamentoPrescrito = new MedicamentoPrescrito(
                1,
                MedicamentoModelo.buscarMedicamentoCodigo(1),
                ConsultaModelo.buscarConsultaCodigo(1),
                "1 comprimido todo dia, pela manhã ou antes do almoço"
        );

        inserirMedicamentoPrescrito(medicamentoPrescrito);
        ArrayList<MedicamentoPrescrito> mp = buscarMedicamentosPrescritos();
        buscarMedicamentoPrescritoCodigo(1);
        imprimirMedicamentosPrescritos(mp);

        System.out.println(mp);
    }
}
