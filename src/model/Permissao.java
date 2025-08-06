/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pixtoladelego
 */
public enum Permissao {
// Clientes
    CADASTRAR_CLIENTE,
    VISUALIZAR_CLIENTE,
    EDITAR_CLIENTE,
    EXCLUIR_CLIENTE,

    // Discos
    CADASTRAR_DISCO,
    VISUALIZAR_DISCO,
    EDITAR_DISCO,
    EXCLUIR_DISCO,

    // Fornecedores
    CADASTRAR_FORNECEDOR,
    VISUALIZAR_FORNECEDOR,
    EDITAR_FORNECEDOR,
    EXCLUIR_FORNECEDOR,

    // Vendas
    REALIZAR_VENDA,

    // Usuários do sistema
    REMOVER_USUARIO
}