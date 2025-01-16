package com.udihealth.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

    public ConexaoMySQL() {} // construtor vazio - permite inicialização da instância de um objeto classe ConexaoMySQL

    public Connection conectar() {

        Connection conexao = null;

        try {
            System.out.println("Conectando ao Banco de Dados...");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String ip = "127.0.0.1"; // "Localhost"; IP do servidor de banco de dados
            String user = "root"; // Nome do usuário
            String bd = "UDI_HEALTH"; // Nome do banco de dados
            String pwd = "15251905"; // A senha para acessar o banco de dados

            conexao = DriverManager.getConnection(
                    "jdbc:mysql://" + ip + "/" + bd, // Localização e nome do banco de dados
                    user, // Usuário
                    pwd // Senha
            );
            
            System.out.println("Conectado.");
            System.out.println("Conexão: " + conexao);
        } catch (ClassNotFoundException | SQLException err) {
            System.out.println(err);
        }
        // Após feitas as etapas da conexão, é hora de retornarn um objeto ConexaoMySQL
        return conexao;
    }
    
    // método 'main' de teste
    public static void main(String[] args) {
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL();
        conexaoMySQL.conectar();
    }
}
