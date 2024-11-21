package com.udihealth.modelo;

import java.util.ArrayList;
import java.sql.*;
import com.udihealth.conexao.ConexaoMySQL;
import com.udihealth.dominio.Usuario;
import com.udihealth.dominio.Paciente;
import com.udihealth.dominio.Medico;
import com.udihealth.dominio.Status;
import java.time.LocalDate;

public class UsuarioModelo {

    public UsuarioModelo() {
    }

    public static ArrayList<Usuario> buscarUsuarios() {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();

        ArrayList<Usuario> usuarios = new ArrayList();

        try {
            String query = "SELECT * FROM USUARIO WHERE status = 'ATIVO' ORDER BY nome";

            // Declaração de um comando SQL
            Statement stm = conexao.createStatement();

            // O app Java vai fazer a consulta no banco e mandar os resultados aqui, em forma do objeto ResulSet
            ResultSet resultado = stm.executeQuery(query);

            while (resultado.next()) {

                Usuario usuario = new Usuario(
                        resultado.getInt("cod_usuario"),
                        resultado.getString("nome"),
                        resultado.getString("senha"),
                        resultado.getDate("data_nascimento"),
                        resultado.getString("sexo").charAt(0), // Converte a String para Character
                        resultado.getString("cpf"),
                        resultado.getString("cep"),
                        resultado.getString("telefone"),
                        resultado.getString("email"),
                        Status.valueOf(resultado.getString("status").toUpperCase())
                );

                usuarios.add(usuario); // Adiciona novo usuário na lista de usuários para imprimí-los                   
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }
        return usuarios;
    }

    public static Usuario buscarUsuarioCodigo(int codigo) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();
        Usuario usuario = new Usuario(); // Cria um objeto usuário

        try {
            String query = "SELECT * FROM USUARIO "
                    + "WHERE cod_usuario = " + codigo; // Criando o texto da consulta ou query
            Statement stm = conexao.createStatement(); // EStabelece um statement para utilizar a consulta
            ResultSet resultado = stm.executeQuery(query); // Executa a consulta e cria um objeto que guarda os dados gerados

            while (resultado.next()) {
                usuario.setCodigoUsuario(resultado.getInt("cod_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataNascimento(resultado.getDate("data_nascimento"));
                usuario.setSexo(resultado.getString("sexo").charAt(0)); // Converte a String para Character
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setTelefone(resultado.getString("telefone"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setStatus(Status.valueOf(resultado.getString("status")));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return usuario;
    }

    public static Usuario buscarUsuarioCPF(String cpf) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();
        Usuario usuario = new Usuario(); // Cria um objeto usuário

        try {
            String query = "SELECT * FROM USUARIO "
                    + "WHERE cpf = " + cpf; // Criando o texto da consulta ou query
            Statement stm = conexao.createStatement(); // EStabelece um statement para utilizar a consulta
            ResultSet resultado = stm.executeQuery(query); // Executa a consulta e cria um objeto que guarda os dados gerados

            while (resultado.next()) {
                usuario.setCodigoUsuario(resultado.getInt("cod_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataNascimento(resultado.getDate("data_nascimento"));
                usuario.setSexo(resultado.getString("sexo").charAt(0)); // Converte a String para Character
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setTelefone(resultado.getString("telefone"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setStatus(Status.valueOf(resultado.getString("status")));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return usuario;
    }

    public static Usuario verificarLogin(Usuario user) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        Connection conexao = conexaoMySQL.conectar();
        Usuario usuario = new Usuario(); // Cria um objeto usuário

        try {
            String query = "SELECT * FROM USUARIO WHERE cpf = " + user.getCpf() + " AND senha = " + user.getSenha() + ";"; // Criando o texto da consulta ou query
            Statement stm = conexao.createStatement(); // EStabelece um statement para utilizar a consulta
            ResultSet resultado = stm.executeQuery(query); // Executa a consulta e cria um objeto que guarda os dados gerados

            while (resultado.next()) {
                usuario.setCodigoUsuario(resultado.getInt("cod_usuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setDataNascimento(resultado.getDate("data_nascimento"));
                usuario.setSexo(resultado.getString("sexo").charAt(0)); // Converte a String para Character
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setCep(resultado.getString("cep"));
                usuario.setTelefone(resultado.getString("telefone"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setStatus(Status.valueOf(resultado.getString("status")));
            }
        } catch (SQLException err) {
            System.err.println("Não foi possível realizar a consulta. " + err.getSQLState());
        }

        return usuario;
    }

    public static void inserirUsuario(Usuario us) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        try {
            String query = "INSERT INTO USUARIO"
                    + "(nome, senha, data_nascimento, sexo, cpf, cep, telefone, email, status)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, us.getNome());
            pstm.setString(2, us.getSenha());
            pstm.setDate(3, us.getDataNascimento());
            pstm.setString(4, us.getSexo() + "");
            pstm.setString(5, us.getCpf());
            pstm.setString(6, us.getCep());
            pstm.setString(7, us.getTelefone());
            pstm.setString(8, us.getEmail());

            if (us.getStatus() != null) {
                pstm.setString(9, us.getStatus().toString());
            } else {
                pstm.setNull(9, java.sql.Types.VARCHAR); // Define NULL se o status for nulo
            }

            pstm.executeUpdate();

            // Obter a chave primária gerada
            ResultSet generatedKeys = pstm.getGeneratedKeys();
            if (generatedKeys.next()) {
                us.setCodigoUsuario(generatedKeys.getInt(1));
            }
            System.out.println("Código: " + us.getCodigoUsuario());
            pstm.close();

            // Chama o método de inserção específico
            if (us instanceof Paciente) {
                PacienteModelo.inserirPaciente((Paciente) us);
            } else if (us instanceof Medico) {
                MedicoModelo.inserirMedico((Medico) us);
            } else {
                System.err.println("Nem médico, nem paciente está sendo inserido no banco.");
            }
            System.out.println("Novo usuário inserido!\n Data nasc.: " + us.getDataNascimento());
            System.out.println(us);
        } catch (SQLException err) {
            System.err.println("Erro ao inserir usuário: " + err.getMessage());
        }
    }

    public static void imprimirUsuarios(ArrayList<Usuario> array) {
        System.out.println("Usuários");
        for (Usuario us : array) {
            // E pra cada usuário de cada linha da tabela USUARIO consultada...
            //...imprima-os
            System.out.println(us.toString());
        }
    }

    public static void atualizarUsuario(int codigo, Usuario us) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        
        us.setCodigoUsuario(codigo);
        
        String query = "UPDATE USUARIO "
                + "SET nome = '" + us.getNome() + "', "
                + "senha = '" + us.getSenha() + "', "
                + "telefone = '" + us.getTelefone() + "', "
                + "email = '" + us.getEmail() + "' "
                + "WHERE cod_usuario = " + codigo;
        System.out.println(query);
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();            
            pstm.close();
            
            // Chama o método de inserção específico
            if (us instanceof Paciente) {
                PacienteModelo.atualizarPaciente((Paciente) us);
            } else if (us instanceof Medico) {
                MedicoModelo.atualizarMedico((Medico) us);
            } else {
                System.err.println("Nem médico, nem paciente está sendo inserido no banco.");
            }

            System.out.println("Usuário atualizado!");
        } catch (SQLException err) {
            System.err.println("Não foi possível atualizar o usuário. " + err);
        }
    }

    public static void alterarStatusUsuario(int codigo, boolean bool) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        Connection con = conexao.conectar();

        Status status;

        if (bool) {
            status = Status.ATIVO;
        } else {
            status = Status.INATIVO;
        }

        String res = "O Usuário " + buscarUsuarioCodigo(codigo).getNome()
                + " está " + status.toString() + "!";

        String query = "UPDATE USUARIO "
                + "SET status = '" + status + "' "
                + "WHERE cod_usuario = " + codigo;
        System.out.println(query);
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.executeUpdate();
            System.out.println(res);
        } catch (SQLException err) {
            System.err.println("Não foi possível altrar o status o usuário. " + err);
        }
    }

    public static void main(String[] args) {
        /*
        Usuario novoUsuario = new Usuario(
                1,
                "Victor Valadão",
                "senhaaaaaaaaaaa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998779645",
                "victorvaladaotete2010@gmail.com",
                Status.ATIVO
        );

        inserirUsuario(novoUsuario);

        Medico user = new Medico(
                1,
                "7",
                1,
                "Jozué",
                "senha123",
                Date.valueOf("2006-04-19"),
                'M',
                "15976867600",
                "3840134",
                "34998779645",
                "eduardo@gmailson.com",
                Status.ATIVO
        );

        atualizarUsuario(4, user);
        
        imprimirUsuarios(buscarUsuarios());

        alterarStatusUsuario(3, false);
        */
        Usuario us = new Usuario();
        us.setCpf("15976867600");

        verificarLogin(us);
    }

}
