
package menus;

import gerenciadores.GFilme;
import gerenciadores.GFoto;
import java.util.Scanner;

public class Principal {

    public void Menu() {
        int opcao;
        Scanner entrada = new Scanner(System.in);       
        do {
            System.out.println("Banco de Midias.\n"
                    + "Escolha um tipo de mídia desejada:");
            System.out.println("1- Música");
            System.out.println("2- Foto");
            System.out.println("3- Ebook");
            System.out.println("4- Filme");
            System.out.println("5- Partituras");
            System.out.println("6- Sair");
            opcao = entrada.nextInt();
            switch (opcao) {

                case 1:
                    musica();
                    break;
                case 2:
                    foto();
                    break;
                case 3:
                    ebook();
                    break;
                case 4:
                    filme();
                    break;
                case 5:
                    partituras();
                    break;
                case 6:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        } while (opcao != 6);

    }

    private void musica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void foto() {
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
    }

    private void ebook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void filme() {
         Scanner entrada = new Scanner(System.in);
        GFilme gerenciador = new GFilme();
        System.out.println("1- Adicionar Filme  2- Editar Filme  3- Exibir Filme  4- Excluir Filme  0- Voltar ao menu Principal");
        int resp = entrada.nextInt();
        while (resp != 0 || resp != 1 || resp != 2 || resp != 3 || resp != 4) {
            if (resp == 0) {
                break;
            }
            if (resp == 1) {
                GFilme i = new GFilme();
                i.adicionar();
            }
            if (resp == 2) {
                GFilme g = new GFilme();
                g.edicao();
            }
            if (resp == 3) {
                GFilme j = new GFilme();
                j.exibir();
            }
            if (resp == 4) {
                GFilme y = new GFilme();
                y.exclusao();
            }
            System.out.println("1- Adicionar Filme  2- Editar Filme  3- Exibir Filme  4- Excluir Filme  0- Voltar ao menu Principal");
            resp = entrada.nextInt();
        }
    }

    private void partituras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Principal sb = new Principal();    
        sb.Menu();      
    }

}


