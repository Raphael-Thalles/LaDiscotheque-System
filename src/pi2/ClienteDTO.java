/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi2;

/**
 *
 * @author Raphael
 */
public class ClienteDTO {
    private int Id;
    private String Nome;
    private String Email;
    private String Telefone;

        // Construtor que aceita os dados
    public ClienteDTO(int Id, String Nome, String Email, String Telefone) {
        this.Id = Id;
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;
    }

    public ClienteDTO(String nome, String cpf, String telefone) {
    this.Nome = nome;
    this.Email = cpf;
    this.Telefone = telefone;
}

    ClienteDTO() {
        
    }

    // Getters e setters
    public int getId() {
        return Id;
    }
    
    public void setId(int Id) {
        this.Id = Id;
    }
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    
     public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    @Override
    public String toString() {
        return Nome; 
    }
}

