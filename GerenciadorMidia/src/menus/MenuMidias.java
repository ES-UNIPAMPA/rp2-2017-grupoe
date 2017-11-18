package menus;

import gerenciadores.GMidia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import midias.Filme;
import midias.Midia;

/**
 *
 * @author Rafael
 */
public class MenuMidias {

    GMidia gerenciadorMidia = new GMidia(new ArrayList());

    void menu(String tipo) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n1- Adicionar " + tipo);
            System.out.println("2- Editar " + tipo);
            System.out.println("3- consultar " + tipo);
            System.out.println("4- Excluir " + tipo);
            System.out.println("0- Voltar ao menu principal.");
            System.out.println("Digite a opção desejada:");
            opcao = entrada.nextInt();
            switch (opcao) {
                case 1:
                    adicionarMidia(tipo);
                    break;
                case 2:
                    //editarMidia();
                    break;
                case 3:
                    // Midia midia = consultarMidia();
                    if (tipo == null) {
                        System.out.println("\n" + tipo + " inexistente.");
                    } else {
                        System.out.println(tipo.toString());
                    }
                    break;
                case 4:
                    //  excluirMidia();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\nA Opção inserida é inválida. Digite novamente, por favor:");
            }
        } while (opcao != 0);
    }

    public boolean adicionarMidia(String tipo) {
        Random gerador = new Random();
        Scanner entrada = new Scanner(System.in);
        List<String> variaveis = new ArrayList();
        String caminho, titulo, descricao, idioma, ano, codigo;
        System.out.println("\nDigite o título:");
        titulo = entrada.nextLine();
        System.out.println("Digite o idioma: ");
        idioma = entrada.nextLine();
        System.out.println("Digite o ano: ");
        ano = entrada.nextLine();
        System.out.println("Digite a descricao: ");
        descricao = entrada.nextLine();
        if (tipo.equalsIgnoreCase("filme")) {
            ArrayList atores = new ArrayList();
            int resp;
            do {
                System.out.println("Digite do Autor principal: ");
                String resposta = entrada.next();
                atores.add(resposta);
                System.out.println("1- Adicionar outro Ator  2- Prosseguir");
                resp = entrada.nextInt();
            } while (resp != 2);
            for (int i = 0; i < Filme.menu.size(); i++) {
                System.out.println(Filme.menu.get(i));
                String respo = entrada.next();
                variaveis.add(i, respo);
            }
            int codigoNumero = gerador.nextInt(1000);
            codigo = "" + codigoNumero;
            System.out.println("Codigo do seu filme: " + codigo);
            caminho = new java.io.File(".").getAbsolutePath() + titulo;
            String genero = variaveis.get(0);
            String diretor = variaveis.get(1);
            String duracao = variaveis.get(2);
            Filme filme = new Filme(codigo, caminho, titulo, descricao, variaveis.get(0), idioma, variaveis.get(1), atores, variaveis.get(2), ano);
            System.out.println(filme.toString());
            if (gerenciadorMidia.adicionar(filme)) {
                System.out.println("\nFilme adicionado com sucesso!");
                return false;
            }
        }
        if (tipo.equalsIgnoreCase("musica")) {
            for (int i = 0; i < Filme.menu.size(); i++) {

            }
        }
        if (tipo.equalsIgnoreCase("partitura")) {
            for (int i = 0; i < Filme.menu.size(); i++) {

            }
        }
        int codigoNumero = gerador.nextInt(1000);
        codigo = "" + codigoNumero;
        System.out.println("Codigo do seu filme: " + codigo);
        caminho = new java.io.File(".").getAbsolutePath();
        //Filme filme = new Filme(codigo, caminho, titulo, descricao, genero, idioma, diretor, atores, duracao, ano);
        System.out.println("\nMidia adicionado com sucesso!");
        return true;
    }
}
