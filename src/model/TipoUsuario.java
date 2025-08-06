/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.EnumSet;
import java.util.Set;

/**
 *
 * @author Raphael
 */
public enum TipoUsuario {
    ATENDENTE(EnumSet.of(
        Permissao.VISUALIZAR_DISCO,
        Permissao.VISUALIZAR_CLIENTE,
        Permissao.REALIZAR_VENDA
    )),
    FINANCEIRO(EnumSet.of(
        Permissao.VISUALIZAR_DISCO,
        Permissao.VISUALIZAR_CLIENTE,
        Permissao.VISUALIZAR_FORNECEDOR,
        Permissao.REALIZAR_VENDA
    )),
    GERENTE(EnumSet.allOf(Permissao.class));

    private final Set<Permissao> permissoes;

    TipoUsuario(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }

    public boolean temPermissao(Permissao p) {
        return permissoes.contains(p);
    }
}