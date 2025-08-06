/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pi2;

import java.time.LocalDate;

/**
 *
 * @author Raphael
 */
public class PedidoDTO {
    private int id;
    private FornecedorDTO fornecedor;
    private String discoPedido;
    private int quantidade;
    private LocalDate dataPedido;
    private String status;

    // Construtor completo
    public PedidoDTO(int id, FornecedorDTO fornecedor, String discoPedido, int quantidade, LocalDate dataPedido, String status) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.discoPedido = discoPedido;
        this.quantidade = quantidade;
        this.dataPedido = dataPedido;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FornecedorDTO getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(FornecedorDTO fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDiscoPedido() {
        return discoPedido;
    }

    public void setDiscoPedido(String discoPedido) {
        this.discoPedido = discoPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
