package br.com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 

/**
 * @author Pedro Gomes
 */
public class ConexaoDAO {  
    
    public Connection conexaoBD() throws ClassNotFoundException {
        Connection con = null;
        
        try {
            // 1. O Driver agora é do PostgreSQL
            Class.forName("org.postgresql.Driver"); 
            
            // 2. Dados de conexão do seu Supabase
            // Substitua o 'db.xxxxxx' pelo seu Host real do painel
        //base     String url = "jdbc:postgresql://db.seu_id_aqui.supabase.co:5432/postgres";
        
          
            String url = "jdbc:postgresql://db.ajvhsqbnrigrapfrwviv.supabase.co:5432/postgressslmode=require";
            
            String usuario = "postgres";
            
           // String senha = "INFO#pg#290990#"; Obs.: Não suporta o # enxerga como delimitador

            String senha = "INFOpg290990";
            
            con = DriverManager.getConnection(url, usuario, senha);

            } catch (ClassNotFoundException e) {
        System.out.println("Driver JDBC nao encontrado: " + e.getMessage());
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("Erro de Conexao Postgres: " + e.getMessage());
        e.printStackTrace();
    }
    return con;
            
///////////////////      
}
