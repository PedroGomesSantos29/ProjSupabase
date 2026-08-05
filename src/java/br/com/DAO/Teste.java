package br.com.DAO;


import br.com.DTO.PhoneDTO;

public class Teste {
    public static void main(String[] args) {
        try {
            System.out.println("Iniciando conexão...");
            
            PhoneDTO dto = new PhoneDTO();
            dto.setnome("Teste Hoje 11/05/2026");
            dto.settelefone("11 9 5511-2026");
            
            PhoneDAO dao = new PhoneDAO();
            dao.cadastrarPhone(dto);
            
            System.out.println(">>> SUCESSO! Verifique seu painel no Supabase.");
            
        } catch (Exception e) {
            System.out.println("Erro no teste: " + e.getMessage());
            e.printStackTrace();
        }
    }
}