package menus;

import java.util.Scanner;

public class Principal {

    MenuMusica menuMusica = new MenuMusica();

    public void Menu() {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("***Banco de Midias***\n"
                    + "Essas são os tipos mídias disponíveis:");
            System.out.println("1- Música");
            System.out.println("2- Filme");
            System.out.println("3- Partituras");
            System.out.println("0- Sair");
            System.out.println("Digite a opção de mídia desejada:");
            opcao = entrada.nextInt();
            switch (opcao) {

                case 1:
                    MenuMusica musica = new MenuMusica();
                    musica.menuMusica();
                    break;
                case 2:
                    MenuFilme menuFilme = new MenuFilme();
                    menuFilme.filme();
                    break;
                case 3:
                    MenuPartitura menuPartitura = new MenuPartitura();
                    menuPartitura.partitura();
                    break;
                case 0:
                    System.out.println("Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;

            }

        } while (opcao != 0);

    }
    public static void main(String[] args) {
        Principal sb = new Principal();
        sb.Menu();
    }

}
