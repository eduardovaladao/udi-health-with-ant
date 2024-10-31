package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.Medico;
import com.udihealth.dominio.Status;
import com.udihealth.dominio.Usuario;

public class MedicoModelo {

    public MedicoModelo() {
    }

    public static void inserirMedico(Medico me) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String consulta = "INSERT INTO MEDICO"
                    + "(crm, cod_usuario)"
                    + "VALUES (?, ?)";

            PreparedStatement pstm = con.prepareStatement(consulta);
            pstm.setString(1, me.getCrm());
            pstm.setInt(2, me.getCodigoUsuario());

            pstm.executeUpdate();
            System.out.println("Novo medico inserido!");
        } catch (SQLException err) {
            System.err.println(err.getSQLState());
        }
    }

    public static ArrayList<Medico> buscarMedicos() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Medico> medicos = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM MEDICO";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                // método "emprestado" do UsuarioControle para extrair as informações do usuário
                // que irá se cadastrar como medico
                Usuario us = UsuarioModelo.buscarUsuarioCodigo(resultado.getInt("cod_usuario"));

                //durante a criação do medico, vamos colocar os atributos do seu respectivo ussuário
                Medico medico = new Medico(
                        resultado.getInt("cod_medico"),
                        resultado.getString("crm"),
                        us.getCodigoUsuario(),
                        us.getNome(),
                        us.getSenha(),
                        us.getDataNascimento(),
                        us.getSexo(),
                        us.getCpf(),
                        us.getCep(),
                        us.getTelefone(),
                        us.getEmail(),
                        us.getStatus()
                );

                medicos.add(medico);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return medicos;

    }

    public static Medico buscarMedicoCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Medico medico = new Medico();

        try {
            String consulta = "SELECT * FROM MEDICO "
                    + "WHERE cod_medico = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                Usuario us = UsuarioModelo.buscarUsuarioCodigo(resultado.getInt("cod_usuario"));

                medico = new Medico(
                        resultado.getInt("cod_medico"),
                        resultado.getString("crm"),
                        us.getCodigoUsuario(),
                        us.getNome(),
                        us.getSenha(),
                        us.getDataNascimento(),
                        us.getSexo(),
                        us.getCpf(),
                        us.getCep(),
                        us.getTelefone(),
                        us.getEmail(),
                        us.getStatus()
                );
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return medico;
    }
    
    public static void atualizarMedico (Medico me) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        String query = "UPDATE MEDICO "
                + "SET crm = '" + me.getCrm()+ "' "
                + "WHERE cod_usuario = " + me.getCodigoUsuario();
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();
            System.out.println("Médico atualizado!");
        } catch (SQLException err) {
            System.err.println("Não foi possível atualizar o médico. " + err);
        }
    }

    public static void imprimirMedicos(ArrayList<Medico> medicos) {
        System.out.println("Medicos:");
        for (Medico me : medicos) {
            System.out.println(me.toString());
        }
    }

    public static void main(String[] args) {
        MedicoModelo medicoControle = new MedicoModelo();

        Medico medico = new Medico(
                1,
                "1452367",
                4,
                "Victor Valadão",
                "minha@senha",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com",
                Status.ATIVO
        );

        medicoControle.inserirMedico(medico);

        ArrayList<Medico> medicos = medicoControle.buscarMedicos();

        medicoControle.imprimirMedicos(medicos);

        System.out.println(medicoControle.buscarMedicoCodigo(1));

        System.out.println("Ok");
    }

}
