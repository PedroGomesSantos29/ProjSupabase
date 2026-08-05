package br.com.DTO;

/**
 * @author Pedro
 */
public class PhoneDTO {

    private int id;
    private String nome;
    private String telefone; // Adicionado o ; que faltava

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String gettelefone() {
        return telefone;
    }

    public void settelefone(String telefone) {
        this.telefone = telefone;
    }
}