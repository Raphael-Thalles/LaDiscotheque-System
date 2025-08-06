package pi2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Raphael
 */


public class DiscoDTO {
    private int id;
    private String Titulo;
    private String Artista;
    private String Genero;
    private int Duracao;
    private int Lancamento;
    private BigDecimal Preco;
    private int Estoque;

    public DiscoDTO(int id, String Titulo, String Artista, String Genero, int Duracao,
                int Lancamento, BigDecimal Preco, int Estoque) {
    this.id = id;
    this.Titulo = Titulo;
    this.Artista = Artista;
    this.Genero = Genero;
    this.Duracao = Duracao;
    this.Lancamento = Lancamento;
    this.Preco = Preco;
    this.Estoque = Estoque;
}
// Construtor vazio
    public DiscoDTO() {
    }
        public int getid() {
    return id;
}

public void setid(int id) {
    this.id = id;
}
    public String getTitulo() {
    return Titulo;
}

public void setTitulo(String Titulo) {
    this.Titulo = Titulo;
}

public String getArtista() {
    return Artista;
}

public void setArtista(String Artista) {
    this.Artista = Artista;
}

public String getGenero() {
    return Genero;
}

public void setGenero(String Genero) {
    this.Genero = Genero;
}

public int getDuracao() {
    return Duracao;
}

public void setDuracao(int Duracao) {
    this.Duracao = Duracao;
}

public int getLancamento() {
    return Lancamento;
}

public void setLancamento(int Lancamento) {
    this.Lancamento = Lancamento;
}

public BigDecimal getPreco() {
    return Preco;
}

public void setPreco(BigDecimal Preco) {
    this.Preco = Preco;
}

public int getEstoque() {
    return Estoque;
}

public void setEstoque(int Estoque) {
    this.Estoque = Estoque;
}
}
