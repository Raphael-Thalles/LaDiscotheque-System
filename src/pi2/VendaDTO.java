
package pi2;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Raphael
 */
public class VendaDTO {
    private int id;
    private DiscoDTO disco;
    private ClienteDTO cliente;
    private LocalDate dataVenda;
    private int quantidade;
    private BigDecimal valorTotal;

    
    public VendaDTO(int id, DiscoDTO disco, ClienteDTO cliente, LocalDate dataVenda, int quantidade, BigDecimal valorTotal) {
        this.id = id;
        this.disco = disco;
        this.cliente = cliente;
        this.dataVenda = dataVenda;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }
    public VendaDTO() {
    
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DiscoDTO getDisco() {
        return disco;
    }

    public void setDisco(DiscoDTO disco) {
        this.disco = disco;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public DiscoDTO getDiscoDTO() {
    return this.disco;
}

public ClienteDTO getClienteDTO() {
    return this.cliente;
}
public BigDecimal calcularTotal() {
    return disco.getPreco().multiply(new BigDecimal(quantidade));
}

}
