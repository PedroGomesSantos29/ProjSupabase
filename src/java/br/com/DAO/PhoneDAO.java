package br.com.DAO;

import br.com.DTO.PhoneDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneDAO {

    // Método para Cadastrar
    public void cadastrarPhone(PhoneDTO objPhoneDTO) throws ClassNotFoundException {
        // Sintaxe correta para Postgres
        String sql = "INSERT INTO Contatos (nome, telefone) VALUES (?, ?)";

        // O try-with-resources abre e fecha tudo automaticamente
        try (Connection con = new ConexaoDAO().conexaoBD();
             PreparedStatement pstm = con.prepareStatement(sql)) {

            pstm.setString(1, objPhoneDTO.getnome()); // Ajuste conforme seu DTO
            pstm.setString(2, objPhoneDTO.gettelefone());

            pstm.execute();
            System.out.println("Inserido com sucesso no Supabase!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    // Método para Listar (Pesquisar)
    public ArrayList<PhoneDTO> pesquisarPhones() throws ClassNotFoundException {
        String sql = "SELECT * FROM contatos ORDER BY nome ASC";
        ArrayList<PhoneDTO> lista = new ArrayList<>();

        try (Connection con = new ConexaoDAO().conexaoBD();
             PreparedStatement pstm = con.prepareStatement(sql);
             ResultSet rs = pstm.executeQuery()) {

            while (rs.next()) {
                PhoneDTO objPhoneDTO = new PhoneDTO();
                // Use os nomes EXATOS das colunas que você criou no Supabase
                objPhoneDTO.setId(rs.getInt("id")); 
                objPhoneDTO.setnome(rs.getString("nome"));
                objPhoneDTO.settelefone(rs.getString("telefone"));

                lista.add(objPhoneDTO);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao pesquisar: " + e.getMessage());
        }
        return lista;
    }
    
    public static void main(String[] args) {
    try {
        System.out.println("------------------------------------------");
        System.out.println("INICIANDO DISPARO PARA SÃO PAULO...");
        
        PhoneDTO teste = new PhoneDTO();
        teste.setnome("Pedro Gomes - Teste Final");
        teste.settelefone("11 99999-0000");

        PhoneDAO dao = new PhoneDAO();
        dao.cadastrarPhone(teste); 
        
        System.out.println(">>> SUCESSO ABSOLUTO! O DADO FOI ENVIADO.");
        System.out.println("------------------------------------------");

    } catch (Exception e) {
        System.out.println("!!! ALGO DEU ERRADO NO MEIO DO CAMINHO !!!");
        System.out.println("Causa do erro: " + e.getMessage());
        e.printStackTrace(); // Isso aqui vai listar o culpado (senha, driver, etc)
    }
}
    
    
    
}