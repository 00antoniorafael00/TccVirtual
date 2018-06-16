package br.edu.ifrs.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    public static Connection abrirConexao() throws Exception {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            //"jdbc:mysql://<nome da máquina ou IP>:3306/<nome do banco de dados>" = String JDBC
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcc_virtual","root","");     //BANCO SEM SENHA
     

        } catch (Exception e) {
            throw new Exception("[br.edu.ifrs.utils.Consexao.abrir] Falha ao abrir conexão com o banco de dados.");
        }
        return conn;
    }
    
}