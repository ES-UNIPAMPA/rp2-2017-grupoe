package menus;

import gerenciadores.GFilme;
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
            System.out.println("2- Foto");
            System.out.println("3- Ebook");
            System.out.println("4- Filme");
            System.out.println("5- Partituras");
            System.out.println("6- Sair");
            System.out.println("Digite a opção de mídia desejada:");
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
                    //1filme();
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
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
           
            System.out.println("1- Adicionar nova música.");
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
                    System.out.println(musica.toString());
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

    private void foto() {
    }

    private void ebook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*
    private void filme() {
        MenuFilme n = new MenuFilme();
        n.inicial();
    }
     */
    private void partituras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        Principal sb = new Principal();
        sb.Menu();
    }

}
