/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi2;

/**
 *
 * @author Raphael
 */
public class FornecedorDTO {
    private int id;
    private String nome_Fornecedor;
    private String contato;
    private String cnpj;

    public FornecedorDTO(int id, String nome_Fornecedor, String contato, String cnpj) {
    this.id = id;
    this.nome_Fornecedor = nome_Fornecedor;
    this.contato = contato;
    this.cnpj = cnpj;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getNome_Fornecedor() {
    return nome_Fornecedor;
}

public void setNome_Fornecedor(String nome_Fornecedor) {
    this.nome_Fornecedor = nome_Fornecedor;
}

public String getContato() {
    return contato;
}

public void setContato(String contato) {
    this.contato = contato;
}

public String getCnpj() {
    return cnpj;
}

public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
}

}