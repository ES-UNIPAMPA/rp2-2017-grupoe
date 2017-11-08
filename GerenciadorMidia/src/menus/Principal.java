
package menus;

import gerenciadores.GFilme;
import java.util.Scanner;

public class Principal {
    MenuMusica menuMusica = new MenuMusica();
    
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
       
    }

    private void foto() {
    }

    private void ebook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void filme() {
         MenuFilme n = new MenuFilme();
         n.inicial();
    }

    private void partituras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Principal sb = new Principal();    
        sb.Menu();      
    }

}


