package menus;

import java.util.Scanner;

import java.lang.NullPointerException;
import gerenciadores.GFoto;

public class MenuFoto {

    public MenuFoto() {

    }

    public boolean menu() {
        Scanner entrada = new Scanner(System.in);
        GFoto gerenciador = new GFoto();
        System.out.println("1- Adicionar Foto  2- Editar Foto  3- Exibir Foto  4- Excluir Foto  0- Voltar ao menu Principal");
        int resp = entrada.nextInt();
        while (resp != 0 || resp != 1 || resp != 2 || resp != 3 || resp != 4) {
            if (resp == 0) {
                break;
            }
            if (resp == 1) {
                GFoto i = new GFoto();
                i.adicionar();
            }
            if (resp == 2) {
                GFoto g = new GFoto();
                g.edicao();
            }
            if (resp == 3) {
                GFoto j = new GFoto();
                j.exibir();
            }
            if (resp == 4) {
                GFoto y = new GFoto();
                y.exclusao();
            }
            System.out.println("1- Adicionar Foto  2- Editar Foto  3- Exibir Foto  4- Excluir Foto  0- Voltar ao menu Principal");
            resp = entrada.nextInt();
        }
        return true;
    }
}
