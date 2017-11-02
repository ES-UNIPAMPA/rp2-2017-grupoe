package menus;

import gerenciadores.GFilme;
import java.util.Scanner;
import midias.Filme;
import gerenciadores.GFilme;
import midias.Midia;

public class MenuFilme {

    public MenuFilme() {

    }

    public boolean menu() {
        Scanner entrada = new Scanner(System.in);
        GFilme gerenciador = new GFilme();
        System.out.println("1- Adicionar Filme  2- Editar Filme  3- Exibir Filme  4- Excluir Filme  0- Voltar ao menu Principal");
        int resp = entrada.nextInt();
        while (resp!=0||resp!=1||resp!=2||resp!=3||resp!=4) {
            if(resp==0){
                break;
            }
            if(resp==1) {
                    GFilme i = new GFilme();
                    i.adicionar();                    
                }
            if(resp==2){              
                    GFilme g = new GFilme();
                    g.edicao();
            }
            if(resp==3){
                    GFilme j = new GFilme();
                    j.exibir();
            }
            if(resp==4){
                    GFilme y = new GFilme();
                    y.exclusao();
            }          
            System.out.println("1- Adicionar Filme  2- Editar Filme  3- Exibir Filme  4- Excluir Filme  0- Voltar ao menu Principal");
            resp = entrada.nextInt();
        }
        return true;
    }
}
