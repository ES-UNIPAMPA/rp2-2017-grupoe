package menus;

import midias.Midia;


/**
 * interface com os métodos do Menu
 * @author Débora Siqueira
 */
public interface IMenu {

    public boolean adicionarMidia();

    public boolean excluirMidia();

    public Midia consultarMidia();

    public boolean editarMidia();
}
