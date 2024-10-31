package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.Paciente;
import com.udihealth.dominio.Usuario;
import com.udihealth.dominio.Status;

public class PacienteModelo {

    public PacienteModelo() {
    }

    public static void inserirPaciente(Paciente pa) {
    ConexaoMySQL conexao = new ConexaoMySQL();
    Connection con = conexao.conectar();

    try {
        String consulta = "INSERT INTO PACIENTE"
                + "(observacoes, cod_usuario)"
                + "VALUES (?, ?)";

        PreparedStatement pstm = con.prepareStatement(consulta);

        pstm.setString(1, pa.getObservacoes());
        pstm.setInt(2, pa.getCodigoUsuario());

        pstm.executeUpdate();
        System.out.println("Novo paciente inserido!");
    } catch (SQLException err) {
        System.err.println(err.getSQLState());
    }
}

    public static ArrayList<Paciente> buscarPacientes() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Paciente> pacientes = new ArrayList<>();

        try {
            String query = "SELECT * FROM PACIENTE";
            Statement stm = conexao.createStatement();
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {
                // método "emprestado" do UsuarioControle para extrair as informações do usuário
                // que irá se cadastrar como paciente
                Usuario us = UsuarioModelo.buscarUsuarioCodigo(resultado.getInt("cod_usuario"));

                //durante a criação do paciente, vamos colocar os atributos do seu respectivo ussuário
                Paciente paciente = new Paciente(
                        resultado.getInt("cod_paciente"),
                        resultado.getString("observacoes"),
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

                pacientes.add(paciente);
                System.out.println(paciente);
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return pacientes;
    }

    public static Paciente buscarPacienteCodigo(int codigo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Paciente paciente = new Paciente();

        try {
            String consulta = "SELECT * FROM PACIENTE "
                    + "WHERE cod_paciente = " + codigo;
            Statement stm = con.createStatement();
            ResultSet resultado = stm.executeQuery(consulta);

            while (resultado.next()) {
                Usuario us = UsuarioModelo.buscarUsuarioCodigo(resultado.getInt("cod_usuario"));

                paciente = new Paciente(
                        resultado.getInt("cod_paciente"),
                        resultado.getString("observacoes"),
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

        return paciente;
    }

    public static void imprimirPacientes(ArrayList<Paciente> pacientes) {
        System.out.println("Pacientes:");
        for (Paciente pa : pacientes) {
            System.out.println(pa.toString());
        }
    }
    
    public static void atualizarPaciente (Paciente pa) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        String query = "UPDATE PACIENTE "
                + "SET observacoes = '" + pa.getObservacoes()+ "' "
                + "WHERE cod_usuario = " + pa.getCodigoUsuario();
        System.out.println(query);
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();
            System.out.println("Paciente atualizado!");
        } catch (SQLException err) {
            System.err.println("Não foi possível atualizar o paciente. " + err);
        }        
    }

    public static void main(String[] args) {
        PacienteModelo pacienteControle = new PacienteModelo();

        Paciente paciente = new Paciente(
                1,
                "Alergia a picada de insetos",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com",
                Status.ATIVO
        );

        pacienteControle.inserirPaciente(paciente);

        ArrayList<Paciente> pacientes = buscarPacientes();

        imprimirPacientes(pacientes);

        buscarPacienteCodigo(1);

        System.out.println("Ok");
    }

}
