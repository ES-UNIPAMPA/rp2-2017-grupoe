package menus;

import gerenciadores.GMusica;
import java.util.Random;
import java.util.Scanner;
import midias.Midia;
import midias.Musica;

/**
 *
 * @author Débora Siqueira
 */
public class MenuMusica implements IMenu {

    GMusica gerenciadorMusica = new GMusica();

    @Override
    public boolean adicionarMidia() {
        Random gerador = new Random();
        Scanner entrada = new Scanner(System.in);
        String titulo, genero, idioma, autores, ano, duracao, descricao, interpretes, caminho, codigo;
        System.out.println("Digite o título da música:");
        titulo = entrada.nextLine();
        System.out.println("Digite o genero da música:");
        genero = entrada.nextLine();
        System.out.println("Digite o idioma da música:");
        idioma = entrada.nextLine();
        System.out.println("Digite os autores da música:");
        autores = entrada.nextLine();
        System.out.println("Digite o ano da música:");
        ano = entrada.nextLine();
        System.out.println("Digite a duração da música:");
        duracao = entrada.nextLine();
        System.out.println("Digite a descrição da música:");
        descricao = entrada.nextLine();
        System.out.println("Digite os interpretes da música:");
        interpretes = entrada.nextLine();
        System.out.println("Digite um codigo qualquer: ");
        codigo = entrada.nextLine();
        caminho = "C:\\Débora\\Área de Trabalho";
        Musica musica = new Musica(codigo, caminho, titulo, descricao, genero, autores, ano, duracao, interpretes, idioma);
        if (gerenciadorMusica.adicionar(musica)) {
            System.out.println("Música adicionada com sucesso!");
            return true;
        }
        return false;
    }

    @Override
    public boolean excluirMidia() {
        Scanner entrada = new Scanner(System.in);
        String excluir;
        System.out.println("Digite o codigo da música que deseja excluir:");
        excluir = entrada.nextLine();
        if (gerenciadorMusica.exclusao(excluir)) {
            System.out.println("Música excluida com sucesso!");
            return true;
        } else {
            System.out.println("Não foi possivel excluir a música!");
            return false;

        }

    }

    @Override
    public Midia consultarMidia() {
        Scanner entrada = new Scanner(System.in);
        String consulta;
        System.out.println("Digite o codigo da música que desejas consultar:");
        consulta = entrada.nextLine();
        Musica musica = (Musica) gerenciadorMusica.consulta(consulta);
        return musica;

    }

    @Override
    public boolean editarMidia() {
        Scanner entrada = new Scanner(System.in);
        String editar;
// Ainda vou criar o editar assim que eu souber como fazer o : Tecle enter caso nao queira editar. :) 
        return false;
    }

}
