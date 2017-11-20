
package menus;

import gerenciadores.GMidia;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import midias.Filme;
import midias.Musica;
import midias.Partitura;

/**
 *
 * @author Rafael
 */
public class Adiciona {
    
     /**
     * Método para adicionar uma nova midia
     *
     * @param tipo
     * @param midia
     * @return retorna true caso a nova midia seja adicionada. Caso contrário
     * retorna false
     */
    public boolean adicionarMidia(String tipo, GMidia midia) {
        Random gerador = new Random();
        int codigoNumero = gerador.nextInt(1000);
        Scanner entrada = new Scanner(System.in);
        List<String> variaveis = new ArrayList();

        //declaração de variaveis incomuns
        String codigo, titulo = null, ano = null, descricao = null, genero = null, resp = null, caminho;

        //menu geral para todos
        codigo = "" + codigoNumero;
        System.out.println("\nDigite o título:");
        titulo = ValidarEntradaUsuario.nextLine(titulo);
        System.out.println("Digite o ano: ");
        ano = ValidarEntradaUsuario.nextInt(ano);
        System.out.println("Digite o genero: ");
        genero = ValidarEntradaUsuario.nextLine(genero);
        System.out.println("Digite a descricao: ");
        descricao = ValidarEntradaUsuario.nextLine(descricao);

        //Aqui inicia os menus que cada midia tem diferente
        //MENU FILME
        if (tipo.equalsIgnoreCase("filme")) {
            ArrayList atores = new ArrayList();
            do {
                System.out.println("Digite o nome do Ator principal: ");
                String ator = null;
                ator = ValidarEntradaUsuario.nextLine(ator);
                atores.add(ator);
                System.out.println("Digite S caso queira adicionar outro Ator");
                resp = ValidarEntradaUsuario.nextLine(resp);
            } while (resp.equalsIgnoreCase("S"));
            for (int i = 0; i < Filme.menu.size(); i++) {
                System.out.println(Filme.menu.get(i));
                if (i == 2) {
                    resp = ValidarEntradaUsuario.nextDouble(resp);
                    resp = resp.replaceAll("\\.", ":");
                    variaveis.add(i, resp);
                    break;
                }
                resp = ValidarEntradaUsuario.nextLine(resp);
                variaveis.add(i, resp);
            }
            System.out.println("Codigo do seu filme: " + codigo);
            caminho = new java.io.File(".").getAbsolutePath() + titulo;
            Filme filme = new Filme(codigo, caminho, titulo, descricao, genero, variaveis.get(0), variaveis.get(1), atores, variaveis.get(2), ano);
            midia.adicionar(filme);
        }

        //MENU MUSICA
        if (tipo.equalsIgnoreCase("musica")) {
            ArrayList autores = new ArrayList();
            ArrayList interpretes = new ArrayList();
            do {
                System.out.println("Digite o nome do Autor: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                autores.add(resp);
                System.out.println("Digite S caso queira adicionar outro Autor");
                resp = ValidarEntradaUsuario.nextLine(resp);
            } while (resp.equalsIgnoreCase("S"));
            do {
                System.out.println("Digite o nome do Interprete: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                interpretes.add(resp);
                System.out.println("Digite S caso queira adicionar outro Interprete");
                resp = ValidarEntradaUsuario.nextLine(resp);
            } while (resp.equalsIgnoreCase("S"));
            for (int i = 0; i < Musica.menu.size(); i++) {
                System.out.println(Musica.menu.get(i));
                if (i == 1) {
                    resp = ValidarEntradaUsuario.nextDouble(resp);
                    resp = resp.replaceAll("\\.", ":");
                    variaveis.add(i, resp);
                    break;
                }
                resp = ValidarEntradaUsuario.nextLine(resp);
                variaveis.add(i, resp);
            }
            System.out.println("Codigo da sua musica: " + codigo);
            caminho = new java.io.File(".").getAbsolutePath() + titulo;
            Musica musica = new Musica(codigo, caminho, titulo, descricao, genero, autores, ano, variaveis.get(1), interpretes, variaveis.get(0));
            midia.adicionar(musica);
        }

        //MENU PARTITURA
        if (tipo.equalsIgnoreCase("partitura")) {
            ArrayList autores = new ArrayList();
            ArrayList instrumentos = new ArrayList();
            do {
                System.out.println("Digite o nome do Autor: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                autores.add(resp);
                System.out.println("Digite S caso queira adicionar outro Autor");
                resp = ValidarEntradaUsuario.nextLine(resp);
            } while (resp.equalsIgnoreCase("S"));
            do {
                System.out.println("Digite o nome do Instrumento: ");
                resp = ValidarEntradaUsuario.nextLine(resp);
                instrumentos.add(resp);
                System.out.println("Digite S caso queira adicionar outro Instrumento");
                resp = ValidarEntradaUsuario.nextLine(resp);
            } while (resp.equalsIgnoreCase("S"));
            System.out.println("Codigo da sua partitura: " + codigo);
            caminho = new java.io.File(".").getAbsolutePath() + titulo;
            Partitura partitura = new Partitura(codigo, caminho, titulo, descricao, instrumentos, ano, autores, genero);
            midia.adicionar(partitura);
        }

        System.out.println(
                "\nMidia adicionada com sucesso!");

        return true;
    }
    
}
