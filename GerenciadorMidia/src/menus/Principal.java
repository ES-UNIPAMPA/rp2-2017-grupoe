package menus;

import java.util.Scanner;
import midias.Musica;

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
                    musica();
                    break;
                case 2:
                    MenuFilme menuFilme = new MenuFilme();
                    menuFilme.filme();
                    break;
                case 3:
                    partituras();
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

    private void musica() {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {

            System.out.println("\n1- Adicionar nova música.");
            System.out.println("2- Editar música.");
            System.out.println("3- consultar música.");
            System.out.println("4- Excluir música.");
            System.out.println("5- Voltar ao menu principal.");
            System.out.println("Digite a opção desejada:");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    menuMusica.adicionarMidia();
                    break;
                case 2:
                    menuMusica.editarMidia();
                    break;
                case 3:
                    Musica musica = (Musica) menuMusica.consultarMidia();
                    if (musica == null) {
                        System.out.println("Musica inexistente.");
                    } else {
                        System.out.println(musica.toString());
                    }
                    break;
                case 4:
                    menuMusica.excluirMidia();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("A Opção inserida é inválida. Digite novamente, por favor:");
            }
        } while (opcao != 5);
    }

    private void partituras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Principal sb = new Principal();
        sb.Menu();
    }

}
