package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raphael
 */
public class UsuarioDTO {
    private String login;
    private String senha;
    private String nome;
    private TipoUsuario tipo;

    public UsuarioDTO(String login, String senha, TipoUsuario tipo) {
        this.login  = login;
        this.senha  = senha;
        this.tipo   = tipo;
        this.nome   = login; // ou receba nome como parâmetro
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    /** Verifica qualquer permissão sobre este usuário */
    public boolean temPermissao(Permissao p) {
        return tipo.temPermissao(p);
    }
    
    // Clientes
public boolean podeCadastrarCliente() {
    return temPermissao(Permissao.CADASTRAR_CLIENTE);
}

public boolean podeVisualizarCliente() {
    return temPermissao(Permissao.VISUALIZAR_CLIENTE);
}

public boolean podeEditarCliente() {
    return temPermissao(Permissao.EDITAR_CLIENTE);
}

public boolean podeExcluirCliente() {
    return temPermissao(Permissao.EXCLUIR_CLIENTE);
}

// Discos
public boolean podeCadastrarDisco() {
    return temPermissao(Permissao.CADASTRAR_DISCO);
}

public boolean podeVisualizarDisco() {
    return temPermissao(Permissao.VISUALIZAR_DISCO);
}

public boolean podeEditarDisco() {
    return temPermissao(Permissao.EDITAR_DISCO);
}

public boolean podeExcluirDisco() {
    return temPermissao(Permissao.EXCLUIR_DISCO);
}

// Fornecedores
public boolean podeCadastrarFornecedor() {
    return temPermissao(Permissao.CADASTRAR_FORNECEDOR);
}

public boolean podeVisualizarFornecedor() {
    return temPermissao(Permissao.VISUALIZAR_FORNECEDOR);
}

public boolean podeEditarFornecedor() {
    return temPermissao(Permissao.EDITAR_FORNECEDOR);
}

public boolean podeExcluirFornecedor() {
    return temPermissao(Permissao.EXCLUIR_FORNECEDOR);
}

// Venda
public boolean podeRealizarVenda() {
    return temPermissao(Permissao.REALIZAR_VENDA);
}

// Usuários
public boolean podeRemoverUsuario() {
    return temPermissao(Permissao.REMOVER_USUARIO);
}

}