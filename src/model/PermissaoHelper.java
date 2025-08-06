package model;

import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author Raphael
 */
public class PermissaoHelper {


    public static void configurarPermissoesListagem(
            JPopupMenu menu,
            UsuarioDTO usuario,
            Permissao permEditar,
            Permissao permExcluir) {

        for (Component comp : menu.getComponents()) {
            if (!(comp instanceof JMenuItem)) continue;
            JMenuItem item = (JMenuItem) comp;
            switch (item.getText()) {
                case "Editar":
                    item.setEnabled(usuario.temPermissao(permEditar));
                    break;
                case "Excluir":
                    item.setEnabled(usuario.temPermissao(permExcluir));
                    break;
                default:
                    // Outras opções não alteram
                    break;
            }
        }
    }
}